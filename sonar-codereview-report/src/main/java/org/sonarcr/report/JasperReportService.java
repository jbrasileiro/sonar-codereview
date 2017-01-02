package org.sonarcr.report;

public interface JasperReportService {

    void export(
        final JasperCompiler compiler,
        final JasperPrinter printer,
        final JasperExporter exporter,
        final String path);
}
