/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 * 
 */
package org.sonarcr.report.beans;

public final class ReportCodeReviewParameter {

    private String headerLogoPath;
    private String projectLogoPath;

    public ReportCodeReviewParameter() {
        super();
    }

    public String getHeaderLogoPath() {
        return headerLogoPath;
    }

    public void setHeaderLogoPath(
        final String headerLogoPath) {
        this.headerLogoPath = headerLogoPath;
    }

    public String getProjectLogoPath() {
        return projectLogoPath;
    }

    public void setProjectLogoPath(
        final String projectLogoPath) {
        this.projectLogoPath = projectLogoPath;
    }
}
