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
