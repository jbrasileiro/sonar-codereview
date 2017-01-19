package org.sonarcr.report;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.sonarcr.commons.resources.ResourceLoader;
import org.sonarcr.report.beans.CodeReviewSingleReport;
import org.sonarcr.report.beans.ReportCodeReviewParameter;
import org.sonarcr.report.utils.JasperCompilerUtils;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class SonarReportServiceImp
    implements
    SonarReportService {

    private final JasperReportPDFService jasperReportPDFService;
    private JasperReportService jasperReportService;

    public SonarReportServiceImp(
        final JasperReportPDFService jasperReportPDFService) {
        super();
        this.jasperReportPDFService = jasperReportPDFService;
    }

    @Override
    public void reportCodeReview(
        final String artifactId,
        final Collection<CodeReviewSingleReport> beans,
        final ReportCodeReviewParameter parameter,
        final File directory) {
        if (directory == null) {
            throw new IllegalArgumentException("directory can't be null.");
        } else {
            if (!directory.exists()) {
                directory.mkdirs();
            }
        }
        if (parameter == null) {
            throw new IllegalArgumentException("Parameter can't be null.");
        }
        final Map<String, Object> parameters = getParameter(parameter);
        final File jrxmlFile = getJRXMLFile("codereview-single-report.jrxml");
        final String name = "codereview".concat(artifactId).concat("-report.pdf");
        final String path = directory.getPath().concat("//").concat(name);
        final JRDataSource dataSource = new JRBeanCollectionDataSource(beans);
        final JasperPrinter printer = new JasperPrinterImp(parameters, dataSource);
        jasperReportPDFService.exportToPDF(jrxmlFile.getPath(), printer, path);
    }

    private Map<String, Object> getParameter(
        final ReportCodeReviewParameter parameter) {
        final File jrxmlFile = getJRXMLFile("codereview-single-detail-report.jrxml");
        final File directory = JasperCompilerUtils.getJasperDirectory();
        new JasperCompilerLocal(jrxmlFile.getPath(), directory).compile();
        final String subReport
            = directory.getPath().concat("/codereview-single-detail-report.jasper");
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("REPORT_TOP_ISSUE", subReport);
        parameters.put("LOGO_HEADER", parameter.getHeaderLogoPath());
        parameters.put("LOGO_PROJECT", parameter.getProjectLogoPath());
        return parameters;
    }

    private File getJRXMLFile(
        final String name) {
        return ResourceLoader.loadFrom(getClass(), "jasper/", name);
    }
}
