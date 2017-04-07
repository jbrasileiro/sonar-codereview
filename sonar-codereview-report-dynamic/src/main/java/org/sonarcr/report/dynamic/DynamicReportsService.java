/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 */
package org.sonarcr.report.dynamic;

import java.io.File;
import java.util.Collection;

import org.sonarcr.report.commons.beans.CodeReviewSingleReport;

public interface DynamicReportsService {

    /**
     * @param artifactId
     * @param beans
     * @param parameter
     * @param directory
     */
    void generateCodeReviewReport(
        String artifactId,
        Collection<CodeReviewSingleReport> beans,
        File directory);

}
