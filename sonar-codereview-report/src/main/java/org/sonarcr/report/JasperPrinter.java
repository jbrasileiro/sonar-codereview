package org.sonarcr.report;

import net.sf.jasperreports.engine.JasperPrint;

public interface JasperPrinter {

    JasperPrint generateJasperPrint(
        JasperCompiler jasperCompiler);

}
