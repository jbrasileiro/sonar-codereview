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

import net.sf.jasperreports.engine.JRDataSource;

public class CodeReviewSingleReport {

    private String artifactId;
    private String version;
    private String branch;
    private String codeReviewVersion;
    private Integer totalBlocker;
    private Integer totalCritical;
    private Integer totalMajor;
    private Integer totalMinor;
    private Integer totalInfo;
    private JRDataSource topIssues;

    public CodeReviewSingleReport() {
        super();
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(
        final String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(
        final String version) {
        this.version = version;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(
        final String branch) {
        this.branch = branch;
    }

    public String getCodeReviewVersion() {
        return codeReviewVersion;
    }

    public void setCodeReviewVersion(
        final String codeReviewVersion) {
        this.codeReviewVersion = codeReviewVersion;
    }

    public Integer getTotalBlocker() {
        return totalBlocker;
    }

    public void setTotalBlocker(
        final Integer totalBlocker) {
        this.totalBlocker = totalBlocker;
    }

    public Integer getTotalCritical() {
        return totalCritical;
    }

    public void setTotalCritical(
        final Integer totalCritical) {
        this.totalCritical = totalCritical;
    }

    public Integer getTotalMajor() {
        return totalMajor;
    }

    public void setTotalMajor(
        final Integer totalMajor) {
        this.totalMajor = totalMajor;
    }

    public Integer getTotalMinor() {
        return totalMinor;
    }

    public void setTotalMinor(
        final Integer totalMinor) {
        this.totalMinor = totalMinor;
    }

    public Integer getTotalInfo() {
        return totalInfo;
    }

    public void setTotalInfo(
        final Integer totalInfo) {
        this.totalInfo = totalInfo;
    }

    public JRDataSource getTopIssues() {
        return topIssues;
    }

    public void setTopIssues(
        final JRDataSource topIssues) {
        this.topIssues = topIssues;
    }

}
