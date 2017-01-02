package org.sonarcr.core.api;

import java.util.List;

import org.sonar.wsclient.issue.Issue;
import org.sonarcr.core.beans.SonarProject;
import org.sonarcr.core.enums.TypeIssueSeverity;

public interface SonarService {

    SonarProject getSonarProject(
        String url,
        String artifactId);

    List<Issue> queryIssuesToResolve(
        final String url,
        final String artifactId,
        final TypeIssueSeverity severity);

}
