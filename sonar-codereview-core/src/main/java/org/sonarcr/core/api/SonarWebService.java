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
