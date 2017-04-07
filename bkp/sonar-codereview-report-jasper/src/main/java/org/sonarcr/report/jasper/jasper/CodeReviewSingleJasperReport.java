/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 */
package org.sonarcr.report.jasper.jasper;

import org.sonarcr.report.commons.beans.CodeReviewSingleReport;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class CodeReviewSingleJasperReport {

    private final CodeReviewSingleReport bean;

    public CodeReviewSingleJasperReport(
        final CodeReviewSingleReport bean) {
        super();
        this.bean = bean;
    }

    public String getArtifactId() {
        return bean.getArtifactId();
    }

    public String getVersion() {
        return bean.getVersion();
    }

    public String getBranch() {
        return bean.getBranch();
    }

    public String getCodeReviewVersion() {
        return bean.getCodeReviewVersion();
    }

    public Integer getTotalBlocker() {
        return bean.getTotalBlocker();
    }

    public Integer getTotalCritical() {
        return bean.getTotalCritical();
    }

    public Integer getTotalMajor() {
        return bean.getTotalMajor();
    }

    public Integer getTotalMinor() {
        return bean.getTotalMinor();
    }

    public Integer getTotalInfo() {
        return bean.getTotalInfo();
    }

    public JRDataSource getTopIssues() {
        return new JRBeanCollectionDataSource(bean.getTopIssues(), false);
    }
}
