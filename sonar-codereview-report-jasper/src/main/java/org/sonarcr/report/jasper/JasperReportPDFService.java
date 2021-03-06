/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 * 
 */
package org.sonarcr.report.jasper;

import java.io.File;

public interface JasperReportPDFService {

    void exportToPDF(
        String jrxml,
        JasperPrinter printer,
        String path);

    void exportToPDF(
        String jrxml,
        File directory,
        JasperPrinter printer,
        String path);
}
