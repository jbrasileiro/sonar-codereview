package org.sonarcr.report;

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
