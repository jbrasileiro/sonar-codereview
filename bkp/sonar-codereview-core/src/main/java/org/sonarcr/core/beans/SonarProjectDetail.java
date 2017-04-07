/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 * 
 */
package org.sonarcr.core.beans;

public class SonarProjectDetail {

    private String name;
    private String branch;
    private String codeReviewVersion;

    public SonarProjectDetail() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(
        final String name) {
        this.name = name;
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
}
