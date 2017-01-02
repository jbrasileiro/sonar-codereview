package org.sonarcr.report;

import java.util.Map;

import org.sonarcr.report.exception.SonarGeneratorReportException;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class JasperPrinterImp
    implements
    JasperPrinter {

    private final Map<String, Object> parameters;
    private final JRDataSource dataSource;

    public JasperPrinterImp(
        final Map<String, Object> parameters,
        final JRDataSource dataSource) {
        super();
        this.parameters = parameters;
        this.dataSource = dataSource;
    }

    @Override
    public JasperPrint generateJasperPrint(
        final JasperCompiler jasperCompiler) {
        final JasperReport jasperReport = jasperCompiler.compile();
        try {
            return JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        } catch (JRException e) {
            throw new SonarGeneratorReportException(jasperReport, e);
        } catch (Exception e) {
            throw new SonarGeneratorReportException(jasperReport, e);
        }
    }
}
