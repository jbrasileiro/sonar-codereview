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

import java.util.List;

import org.sonar.wsclient.issue.Issue;
import org.sonar.wsclient.services.Resource;
import org.sonarcr.core.beans.SonarProjectDetail;
import org.sonarcr.core.enums.TypeIssueSeverity;
import org.sonarcr.core.enums.TypeIssueStatus;

public interface SonarWebService {

    Resource call(
        final String url,
        String artifactId);

    List<Issue> queryIssues(
        final String url,
        String artifactId,
        TypeIssueSeverity severity,
        TypeIssueStatus status);

    List<Issue> queryIssues(
        final String url,
        String artifactId,
        Iterable<TypeIssueSeverity> severity,
        Iterable<TypeIssueStatus> status);

    SonarProjectDetail getSonarProjectDetail(
        final String url,
        final String artifactId);

}
