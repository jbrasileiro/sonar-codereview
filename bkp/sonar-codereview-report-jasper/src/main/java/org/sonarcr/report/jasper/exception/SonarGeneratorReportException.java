/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 * 
 */
package org.sonarcr.report.jasper.exception;

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
