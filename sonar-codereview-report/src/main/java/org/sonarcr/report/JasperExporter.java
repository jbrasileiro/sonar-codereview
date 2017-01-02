package org.sonarcr.report;

import java.io.File;

import net.sf.jasperreports.engine.JasperPrint;

public interface JasperExporter {

    void export(
        JasperPrint jasperPrint,
        File output);
}
