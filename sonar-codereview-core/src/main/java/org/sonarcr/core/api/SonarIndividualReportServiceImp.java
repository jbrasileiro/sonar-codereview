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

import org.sonar.wsclient.issue.Issue;
import org.sonarcr.commons.comparator.CommonsComparator;
import org.sonarcr.commons.util.EnumsUtils;
import org.sonarcr.commons.util.MapsUtils;
import org.sonarcr.core.beans.IssueOccurrences;
import org.sonarcr.core.beans.IssueOccurrencesComparator;
import org.sonarcr.core.beans.ProjectIssue;
import org.sonarcr.core.beans.SonarProject;
import org.sonarcr.core.enums.TypeIssueSeverity;
import org.sonarcr.core.vo.IssueOccurrenceVO;
import org.sonarcr.report.commons.beans.CodeReviewSingleReport;
import org.sonarcr.report.commons.beans.IssueReport;
import org.sonarcr.report.commons.beans.ReportCodeReviewParameter;
import org.sonarcr.report.commons.commons.ReportResourceLoader;
import org.sonarcr.report.jasper.SonarReportService;

public class SonarIndividualReportServiceImp
    implements
    SonarIndividualReportService {

    private static final int TOP = 1000;
    private static String BLOCKER = "img-blocker_80x64.png";
    private static String CRITICAL = "img-blocker_80x64.png";
    private static String MAJOR = "img-blocker_80x64.png";
    private static String MINOR = "img-blocker_80x64.png";
    private static String INFO = "img-blocker_80x64.png";

    private final SonarReportService jasperReport;
    private final SonarService sonarService;

    public SonarIndividualReportServiceImp(
        final SonarService sonarService,
        final SonarReportService report) {
        super();
        this.sonarService = sonarService;
        jasperReport = report;
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
        //FIXME
        for (IssueReport issue : bean.getTopIssues()) {
            System.err.println(issue);
        }
        jasperReport.reportCodeReview(artifactId, beans, parameter, directory);
        return true;
    }

    private List<IssueReport> toTopIssues(
        final int limit,
        final List<Issue> issues) {
        final List<IssueOccurrences> ordenedIssues = to(limit, issues);
        final List<IssueReport> result = new ArrayList<>();
        for (final IssueOccurrences issue : ordenedIssues) {
            final IssueReport bean = new IssueReport();
            bean.setIssueName(issue.getName());
            bean.setOccurrences(issue.getOccurences());
            bean.setIconPath(getIconPath(issue.getSeverity()));
            result.add(bean);
        }
        return result;
    }

    private String getIconPath(final TypeIssueSeverity type) {
        Map<TypeIssueSeverity, String> map = MapsUtils.getConcurrentHashMap();
        map.put(TypeIssueSeverity.BLOCKER, getIconPath(BLOCKER));
        map.put(TypeIssueSeverity.CRITICAL, getIconPath(CRITICAL));
        map.put(TypeIssueSeverity.MAJOR, getIconPath(MAJOR));
        map.put(TypeIssueSeverity.MINOR, getIconPath(MINOR));
        map.put(TypeIssueSeverity.INFO, getIconPath(INFO));
        return MapsUtils.getType(map, type);
    }

    private String getIconPath(
        final String name) {
        return ReportResourceLoader.loadFrom("\\img", name).getPath();
    }

    private List<IssueOccurrences> to(
        final int limit,
        final List<Issue> issues) {
        final List<IssueOccurrences> result = new ArrayList<>();
        final Map<String, IssueOccurrenceVO> map = new HashMap<>();
        for (final Issue issue : issues) {
            final String key = key(issue);
            if (map.containsKey(key)) {
                IssueOccurrenceVO vo = map.get(key);
                vo.increase();
            } else {
                String name = issue.message();
                TypeIssueSeverity[] enums = TypeIssueSeverity.values();
                TypeIssueSeverity severity = EnumsUtils.valueOfMeaning(enums, issue.severity());
                map.put(key, new IssueOccurrenceVO(name, severity, 1));
            }
        }
        for (final IssueOccurrenceVO entry : map.values()) {
            String key = entry.getName();
            TypeIssueSeverity type = entry.getSeverity();
            Integer value = entry.getOccurrence();
            result.add(new IssueOccurrences(type, key, value));
        }
        Collections.sort(result, getComparator());
        Collections.reverse(result);
        if(result.size() < limit){
            return result.subList(0, result.size());
        }else{
            return result.subList(0, limit);
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


