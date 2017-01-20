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
