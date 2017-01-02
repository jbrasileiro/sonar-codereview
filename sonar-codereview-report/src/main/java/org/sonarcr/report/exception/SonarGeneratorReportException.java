package org.sonarcr.report.exception;

import org.sonarcr.commons.exception.SonarAPIRuntimeException;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public final class SonarGeneratorReportException
    extends
    SonarAPIRuntimeException {

    private static final long serialVersionUID = 1118925358914508747L;

    public SonarGeneratorReportException(
        final JasperReport jasperReport) {
        this(jasperReport, null);
    }

    public SonarGeneratorReportException(
        final JasperPrint jasperPrint,
        final Exception e) {
        this(jasperPrint.getName(), e);
    }

    public SonarGeneratorReportException(
        final JasperReport jasperReport,
        final Exception e) {
        this(jasperReport.getName(), e);
    }

    private SonarGeneratorReportException(
        final String jasperReport,
        final Exception e) {
        super("Error generating jasper report.".concat(jasperReport), e);
    }
}
