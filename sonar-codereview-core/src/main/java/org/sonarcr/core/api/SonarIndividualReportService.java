package org.sonarcr.core.api;

import java.io.File;

import org.sonarcr.report.beans.ReportCodeReviewParameter;

public interface SonarIndividualReportService {

    boolean generateReport(
        String url,
        String artifactId,
        ReportCodeReviewParameter parameter,
        File directory);
}
