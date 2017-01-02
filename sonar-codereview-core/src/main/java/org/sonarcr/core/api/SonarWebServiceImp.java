package org.sonarcr.core.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.sonar.wsclient.Sonar;
import org.sonar.wsclient.internal.HttpRequestFactory;
import org.sonar.wsclient.issue.Issue;
import org.sonar.wsclient.issue.IssueClient;
import org.sonar.wsclient.issue.IssueQuery;
import org.sonar.wsclient.issue.Issues;
import org.sonar.wsclient.issue.internal.DefaultIssueClient;
import org.sonar.wsclient.services.Resource;
import org.sonar.wsclient.services.ResourceQuery;
import org.sonarcr.commons.exception.SonarAPIRuntimeException;
import org.sonarcr.commons.util.ObjectsUtils;
import org.sonarcr.core.beans.SonarProjectDetail;
import org.sonarcr.core.enums.TypeIssueSeverity;
import org.sonarcr.core.enums.TypeIssueStatus;

public final class SonarWebServiceImp
    implements
    SonarWebService {

    public Resource call(
        final String url,
        final String artifactId) {
        final Resource result
            = getSonar(url).find(ResourceQuery.create(artifactId).setVerbose(Boolean.TRUE));
        if (result == null) {
            throw new IllegalArgumentException(artifactId.concat(" not found."));
        } else {
            return result;
        }
    }

    private Sonar getSonar(
        final String url) {
        return Sonar.create(url);
    }

    public List<Issue> queryIssues(
        final String url,
        final String artifactId,
        final Iterable<TypeIssueSeverity> typeSeverity,
        final Iterable<TypeIssueStatus> typeStatus) {
        final HttpRequestFactory requestFactory = new HttpRequestFactory(url);
        final IssueClient client = new DefaultIssueClient(requestFactory);
        final IssueQuery query = createIssueQuery(typeSeverity, typeStatus);
        final IssueQuery componentRoots = query.componentRoots(artifactId);
        final Issues result = client.find(componentRoots);
        return result.list();
    }

    private IssueQuery createIssueQuery(
        final Iterable<TypeIssueSeverity> typeSeverity,
        final Iterable<TypeIssueStatus> typeStatus) {
        final IssueQuery query = IssueQuery.create();
        if (typeSeverity != null) {
            final List<String> values = new ArrayList<>();
            for (final TypeIssueSeverity severity : typeSeverity) {
                values.add(severity.getMeaning());
            }
            query.severities(values.toArray(new String[] {}));
        }
        if (typeStatus != null) {
            final List<String> values = new ArrayList<>();
            for (final TypeIssueStatus status : typeStatus) {
                values.add(status.getMeaning());
            }
            query.statuses(values.toArray(new String[] {}));
        }
        return query;
    }
    
    public SonarProjectDetail getSonarProjectDetail(final String url, final String artifactId){
        final Resource resource = call(url, artifactId);
        final SonarProjectDetail result = new SonarProjectDetail();
        final String name = resource.getName(false);
        if(ObjectsUtils.notNull(name)){
            final int limiter = name.indexOf('_');
            result.setName(name.substring(0, limiter));
            result.setBranch(name.substring(limiter + 1, name.length()));
            result.setCodeReviewVersion(resource.getVersion());
            return result;
        }else{
            throw new SonarAPIRuntimeException("Resource has no name. ".concat(artifactId));
        }
    }

    public List<Issue> queryIssues(
        final String url,
        final String artifactId) {
        return queryIssues(url, artifactId,
            Arrays.asList(TypeIssueSeverity.values()),
            Arrays.asList(TypeIssueStatus.values()));
    }

    public List<Issue> queryIssues(
        final String url,
        final String artifactId,
        final TypeIssueSeverity typeSeverity,
        final TypeIssueStatus typeStatus) {
        final List<TypeIssueSeverity> severities = Arrays.asList(typeSeverity);
        final List<TypeIssueStatus> status = Arrays.asList(typeStatus);
        return queryIssues(url, artifactId, severities, status);
    }

}
