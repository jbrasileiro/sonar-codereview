package org.sonarcr.report;

import java.io.File;

import org.sonarcr.report.exception.SonarGeneratorReportException;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

public class JasperExporterToPDF
    implements
    JasperExporter {

    @Override
    public void export(
        final JasperPrint jasperPrint,
        final File output) {
        try {
            JasperExportManager.exportReportToPdfFile(jasperPrint, output.getPath());
        } catch (final Exception e) {
            throw new SonarGeneratorReportException(jasperPrint, e);
        }
    }
}
