package org.sonarcr.report;

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
