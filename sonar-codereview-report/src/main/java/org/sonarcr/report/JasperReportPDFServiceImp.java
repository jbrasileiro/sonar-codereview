package org.sonarcr.report;

import java.io.File;

public class JasperReportPDFServiceImp
    implements
    JasperReportPDFService {

    private final JasperReportService jasperReportService;

    public JasperReportPDFServiceImp(
        final JasperReportService jasperReportService) {
        super();
        this.jasperReportService = jasperReportService;
    }

    @Override
    public void exportToPDF(
        final String jrxml,
        final JasperPrinter printer,
        final String path) {
        final JasperCompiler compiler = new JasperCompilerLocal(jrxml);
        exportToPDF(printer, path, compiler);
    }

    @Override
    public void exportToPDF(
        final String jrxml,
        final File directory,
        final JasperPrinter printer,
        final String path) {
        final JasperCompiler compiler = new JasperCompilerLocal(jrxml, directory);
        exportToPDF(printer, path, compiler);
    }

    private void exportToPDF(
        final JasperPrinter printer,
        final String path,
        final JasperCompiler compiler) {
        final JasperExporter exporter = new JasperExporterToPDF();
        jasperReportService.export(compiler, printer, exporter, path);
    }
}
