/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 * 
 */
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
