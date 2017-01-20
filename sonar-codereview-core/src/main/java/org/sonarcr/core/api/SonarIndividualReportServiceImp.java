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

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.sonar.wsclient.issue.Issue;
import org.sonarcr.commons.comparator.CommonsComparator;
import org.sonarcr.core.beans.IssueOccurrences;
import org.sonarcr.core.beans.IssueOccurrencesComparator;
import org.sonarcr.core.beans.ProjectIssue;
import org.sonarcr.core.beans.SonarProject;
import org.sonarcr.report.SonarReportService;
import org.sonarcr.report.beans.CodeReviewSingleReport;
import org.sonarcr.report.beans.IssueReport;
import org.sonarcr.report.beans.ReportCodeReviewParameter;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class SonarIndividualReportServiceImp
    implements
    SonarIndividualReportService {

    private static final int TOP = 10;
    private final SonarReportService report;
    private final SonarService sonarService;

    public SonarIndividualReportServiceImp(
        final SonarService sonarService,
        final SonarReportService report) {
        super();
        this.sonarService = sonarService;
        this.report = report;
    }

    @Override
    public boolean generateReport(
        final String url,
        final String artifactId,
        final ReportCodeReviewParameter parameter,
        final File directory) {
        final SonarProject detail = sonarService.getSonarProject(url, artifactId);
        final Collection<CodeReviewSingleReport> beans = new ArrayList<>();
        final CodeReviewSingleReport bean = new CodeReviewSingleReport();
        bean.setArtifactId(detail.getDetail().getName());
        bean.setBranch(detail.getDetail().getBranch());
        bean.setCodeReviewVersion(detail.getDetail().getCodeReviewVersion());
        final ProjectIssue issues = detail.getIssue();
        bean.setTotalBlocker(issues.getBlocker().size());
        bean.setTotalCritical(issues.getCritical().size());
        bean.setTotalMajor(issues.getMajor().size());
        bean.setTotalMinor(issues.getMinor().size());
        bean.setTotalInfo(issues.getInfo().size());
        bean.setTopIssues(toTopIssues(TOP, new ArrayList<>(issues.getAllIssues())));
        beans.add(bean);
        report.reportCodeReview(artifactId, beans, parameter, directory);
        return true;
    }

    private JRDataSource toTopIssues(
        final int limit,
        final List<Issue> issues) {
        final List<IssueOccurrences> ordenedIssues = to(issues);
        final List<IssueReport> result = new ArrayList<>();
        for (final IssueOccurrences issue : ordenedIssues) {
            final IssueReport bean = new IssueReport();
            bean.setIssueName(issue.getName());
            bean.setOccurrences(issue.getOccurences());
            result.add(bean);
        }
        return new JRBeanCollectionDataSource(result, false);
    }

    private List<IssueOccurrences> to(
        final List<Issue> issues) {
        final List<IssueOccurrences> result = new ArrayList<>();
        final Map<String, Integer> map = new HashMap<>();
        for (final Issue issue : issues) {
            final String key = key(issue);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        for (final Entry<String, Integer> entry : map.entrySet()) {
            result.add(new IssueOccurrences(entry.getKey(), entry.getValue()));
        }
        Collections.sort(result, getComparator());
        Collections.reverse(result);
        if(result.size() < TOP){
            return result.subList(0, result.size());
        }else{
            return result.subList(0, TOP);
        }
    }

    private Comparator<IssueOccurrences> getComparator() {
        return new IssueOccurrencesComparator(new CommonsComparator());
    }

    private String key(
        final Issue issue) {
        return issue.message();
    }

}


