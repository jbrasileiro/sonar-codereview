package org.sonarcr.core.api;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.sonarcr.chart.BarChartCategory;
import org.sonarcr.chart.BarChartCategoryImp;
import org.sonarcr.chart.BarChartParameter;
import org.sonarcr.chart.BarChartParameterImp;
import org.sonarcr.chart.JChartGeneratorService;
import org.sonarcr.core.beans.ProjectIssue;
import org.sonarcr.core.beans.SonarProject;
import org.sonarcr.core.enums.TypeIssueSeverity;

public final class SonarChartServiceImp
    implements
    SonarChartService {

    private final SonarService sonar;
    private final JChartGeneratorService jChartGenerator;

    public SonarChartServiceImp(
        final SonarService sonar,
        final JChartGeneratorService jChartGenerator) {
        super();
        this.sonar = sonar;
        this.jChartGenerator = jChartGenerator;
    }

    @Override
    public boolean generateChart(
        final String url,
        final String id,
        final File directory) {
        final SonarProject detail = sonar.getSonarProject(url, id);
        toImage(detail, directory);
        return true;
    }

    private void toImage(
        final SonarProject detail,
        final File directory) {
        final Collection<BarChartParameter> parameters = new ArrayList<>();
        parameters.add(toBarChartParameter(detail));
        jChartGenerator.generate("SONAR", parameters, directory);
    }

    private BarChartParameter toBarChartParameter(
        final SonarProject project) {
        final Collection<BarChartCategory> category = new ArrayList<>();
        final ProjectIssue issue = project.getIssue();
        category.add(new BarChartCategoryImp(TypeIssueSeverity.BLOCKER.getMeaning(), issue.getBlocker().size()));
        category.add(new BarChartCategoryImp(TypeIssueSeverity.CRITICAL.getMeaning(), issue.getCritical().size()));
        category.add(new BarChartCategoryImp(TypeIssueSeverity.MAJOR.getMeaning(), issue.getMajor().size()));
        category.add(new BarChartCategoryImp(TypeIssueSeverity.MINOR.getMeaning(), issue.getMinor().size()));
        category.add(new BarChartCategoryImp(TypeIssueSeverity.INFO.getMeaning(), issue.getInfo().size()));
        category.add(new BarChartCategoryImp("TOTAL", issue.getTotalIssue()));
        return new BarChartParameterImp(project.getDetail().getName(), category);
    }

    @Override
    public boolean generateChart(
        final String url,
        final Collection<String> id,
        final File directory) {
        final Collection<BarChartParameter> parameters = new ArrayList<>();
        for (final String vID : id) {
            final SonarProject detail = sonar.getSonarProject(url, vID);
            parameters.add(toBarChartParameterByType(detail, TypeIssueSeverity.BLOCKER));
            parameters.add(toBarChartParameterByType(detail, TypeIssueSeverity.CRITICAL));
            parameters.add(toBarChartParameterByType(detail, TypeIssueSeverity.MAJOR));
            parameters.add(toBarChartParameterByType(detail, TypeIssueSeverity.MINOR));
            parameters.add(toBarChartParameterByType(detail, TypeIssueSeverity.INFO));
            parameters.add(toBarChartParameterByTotal(detail));
        }
        jChartGenerator.generate("SONAR", parameters, directory);
        return true;
    }
    
    private BarChartParameter toBarChartParameterByTotal(
        final SonarProject project) {
        final Collection<BarChartCategory> category = new ArrayList<>();
        final ProjectIssue issue = project.getIssue();
        category.add(new BarChartCategoryImp(project.getDetail().getName(), issue.getTotalIssue()));
        return new BarChartParameterImp("TOTAL", category);
    }

    private BarChartParameter toBarChartParameterByType(
        final SonarProject project,
        final TypeIssueSeverity type) {
        final Collection<BarChartCategory> category = new ArrayList<>();
        final ProjectIssue issue = project.getIssue();
        category.add(new BarChartCategoryImp(project.getDetail().getName(), issue.get(type).size()));
        return new BarChartParameterImp(type.getMeaning(), category);
    }


}
