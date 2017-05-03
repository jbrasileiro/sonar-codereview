/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 * 
 */
package org.sonarcr.core.api;

import java.io.File;

import org.sonarcr.report.commons.beans.ReportCodeReviewParameter;

public interface SonarIndividualReportService {

    boolean generateReport(
        String url,
        String artifactId,
        ReportCodeReviewParameter parameter,
        File directory);
}