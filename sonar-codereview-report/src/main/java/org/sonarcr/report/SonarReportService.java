package org.sonarcr.report;

import java.io.File;
import java.util.Collection;

import org.sonarcr.report.beans.CodeReviewSingleReport;
import org.sonarcr.report.beans.ReportCodeReviewParameter;

public interface SonarReportService {

    void reportCodeReview(
        String artifactId,
        Collection<CodeReviewSingleReport> beans,
        ReportCodeReviewParameter parameter,
        File directory);

}
