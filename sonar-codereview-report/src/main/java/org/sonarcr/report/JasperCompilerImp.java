package org.sonarcr.report;

import java.io.File;

import org.sonarcr.commons.file.FileDeleter;
import org.sonarcr.report.exception.SonarCompilerReportException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public final class JasperCompilerImp
    implements
    JasperCompiler {

    private final JasperReport jasperReport;

    public JasperCompilerImp(
        final String jrxml) {
        super();
        jasperReport = compile(jrxml);
    }

    public JasperCompilerImp(
        final String jrxml,
        final String jasper) {
        super();
        jasperReport = compile(jrxml, jasper);
    }

    private JasperReport compile(
        final String jrxml) {
        try {
            return JasperCompileManager.compileReport(jrxml);
        } catch (final JRException e) {
            throw new SonarCompilerReportException(jrxml, e);
        } catch (final Exception e) {
            throw new SonarCompilerReportException(jrxml, e);
        }
    }

    private JasperReport compile(
        final String jrxml,
        final String jasper) {
        final File file = new File(jasper);
        FileDeleter.requiredDeleteFile(file);
        file.getParentFile().mkdirs();
        try {
            JasperCompileManager.compileReportToFile(jrxml.replaceAll("\\\\", "\\/"), jasper.replaceAll("\\\\", "\\/"));
            return (JasperReport) JRLoader.loadObjectFromFile(jasper);
        } catch (final JRException e) {
            throw new SonarCompilerReportException(jrxml, e);
        } catch (final Exception e) {
            throw new SonarCompilerReportException(jrxml, e);
        }
    }

    @Override
    public JasperReport compile() {
        return jasperReport;
    }
}
