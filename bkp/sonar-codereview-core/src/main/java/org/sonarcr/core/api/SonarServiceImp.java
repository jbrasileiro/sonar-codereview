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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.sonar.wsclient.issue.Issue;
import org.sonarcr.commons.util.ObjectsUtils;
import org.sonarcr.core.beans.ProjectIssue;
import org.sonarcr.core.beans.SonarProject;
import org.sonarcr.core.beans.SonarProjectDetail;
import org.sonarcr.core.enums.TypeIssueSeverity;
import org.sonarcr.core.enums.TypeIssueStatus;

public class SonarServiceImp
    implements
    SonarService {

    private final SonarWebService sonarWS;

    public SonarServiceImp(
        final SonarWebService sonarWebService) {
        super();
        this.sonarWS = sonarWebService;
    }

    public SonarProject getSonarProject(
        final String url,
        final String artifactId) {
        ObjectsUtils.required(url);
        ObjectsUtils.required(artifactId);
        final ProjectIssue issue = new ProjectIssue();
        issue.setBlocker(queryBlocker(url, artifactId));
        issue.setCritical(queryCritical(url, artifactId));
        issue.setMajor(queryMajor(url, artifactId));
        issue.setMinor(queryMinor(url, artifactId));
        issue.setInfo(queryInfo(url, artifactId));
        final SonarProjectDetail detail
            = sonarWS.getSonarProjectDetail(url, artifactId);
        return new SonarProject(detail, issue);
    }

    public List<Issue> queryIssuesToResolve(
        final String url,
        final String artifactId,
        final TypeIssueSeverity severity) {
        final List<TypeIssueSeverity> severities = Arrays.asList(severity);
        final List<TypeIssueStatus> status = new ArrayList<>();
        status.add(TypeIssueStatus.CONFIRMED);
        status.add(TypeIssueStatus.OPEN);
        status.add(TypeIssueStatus.REOPENED);
        return sonarWS.queryIssues(url, artifactId, severities, status);
    }

    private List<Issue> queryInfo(
        final String url,
        final String artifactId) {
        final TypeIssueSeverity severity = TypeIssueSeverity.INFO;
        return queryIssuesToResolve(url, artifactId, severity);
    }

    private List<Issue> queryMinor(
        final String url,
        final String artifactId) {
        final TypeIssueSeverity severity = TypeIssueSeverity.MINOR;
        return queryIssuesToResolve(url, artifactId, severity);
    }

    private List<Issue> queryMajor(
        final String url,
        final String artifactId) {
        final TypeIssueSeverity severity = TypeIssueSeverity.MAJOR;
        return queryIssuesToResolve(url, artifactId, severity);
    }

    private List<Issue> queryCritical(
        final String url,
        final String artifactId) {
        final TypeIssueSeverity severity = TypeIssueSeverity.CRITICAL;
        return queryIssuesToResolve(url, artifactId, severity);
    }

    private List<Issue> queryBlocker(
        final String url,
        final String artifactId) {
        final TypeIssueSeverity severity = TypeIssueSeverity.BLOCKER;
        return queryIssuesToResolve(url, artifactId, severity);
    }

}
