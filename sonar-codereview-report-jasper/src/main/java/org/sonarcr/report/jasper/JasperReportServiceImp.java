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

import org.sonarcr.commons.file.FileDeleter;

import net.sf.jasperreports.engine.JasperPrint;

public final class JasperReportServiceImp
    implements
    JasperReportService {

    @Override
    public void export(
        final JasperCompiler compiler,
        final JasperPrinter printer,
        final JasperExporter exporter,
        final String path) {
        final JasperPrint jasperPrint = printer.generateJasperPrint(compiler);
        final File file = new File(path);
        FileDeleter.requiredDeleteFile(file);
        exporter.export(jasperPrint, file);
    }
}
