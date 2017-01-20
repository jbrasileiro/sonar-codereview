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

import org.sonarcr.commons.util.ToStringUtils;

public class SonarProject {

    private final SonarProjectDetail detail;
    private final ProjectIssue issue;

    public SonarProject(
        final SonarProjectDetail detail,
        final ProjectIssue issue) {
        super();
        this.detail = detail;
        this.issue = issue;
    }

    public SonarProjectDetail getDetail() {
        return detail;
    }

    public ProjectIssue getIssue() {
        return issue;
    }

    @Override
    public String toString() {
        return ToStringUtils.toString(this);
    }

}
