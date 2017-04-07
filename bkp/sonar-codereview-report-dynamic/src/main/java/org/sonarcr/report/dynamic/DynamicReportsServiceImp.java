/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 */
package org.sonarcr.report.dynamic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;

import org.sonarcr.report.commons.beans.CodeReviewSingleReport;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.exception.DRException;

public class DynamicReportsServiceImp
    implements
    DynamicReportsService {

    @Override
    public void generateCodeReviewReport(
        final String artifactId,
        final Collection<CodeReviewSingleReport> beans,
        final File directory) {
        JasperReportBuilder report = DynamicReports.report();
        report.title(DynamicReports.cmp.centerHorizontal(DynamicReports.cmp.text("Code Review")));
        report.addColumn(DynamicReports.col.column("Projeto", "name", String.class));
//        report.addColumn(DynamicReports.col.column("Projeto", "_project", String.class));
        // report.addColumn(DynamicReports.col.column("ID", "_id",
        // DynamicReports.type.stringType()));
        // report.addColumn(DynamicReports.col.column("Branch", "_branch",
        // DynamicReports.type.stringType()));
        // report.addColumn(DynamicReports.col.column("version", "_version",
        // DynamicReports.type.stringType()));
        report.title(DynamicReports.cmp.text("Code Review"));
        report
            .pageFooter(DynamicReports.cmp.pageXofY().setStyle(DynamicReports.stl.style().bold()));
        report.setDataSource(Arrays.asList(new Ex()));
        try {
            report.toPdf(pdfExporterBuilder());
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private OutputStream pdfExporterBuilder() {
        try {
            File pdf = File.createTempFile("output.", ".pdf");
            System.err.println(pdf.getPath());
            return new FileOutputStream(pdf);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
