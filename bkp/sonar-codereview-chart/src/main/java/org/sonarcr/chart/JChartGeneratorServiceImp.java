/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 * 
 */
package org.sonarcr.chart;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.sonarcr.commons.exception.SonarAPIRuntimeException;

public final class JChartGeneratorServiceImp
    implements
    JChartGeneratorService {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    @Override
    public boolean generate(
        final String title,
        final Collection<BarChartParameter> parameters,
        final File directory) {
        final CategoryDataset dataset = createDataset(parameters);
        final JFreeChart barChart = ChartFactory.createBarChart(title, "Category",
            "Score", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        toImage(directory, barChart);
        return true;
    }

    private void toImage(
        final File output,
        final JFreeChart barChart) {
        if (output.exists() && !output.isDirectory()) {
            throw new SonarAPIRuntimeException("Not a directory.");
        } else {
            output.mkdirs();
        }
        try {
            final File file = new File(output, getName());
            ChartUtilities.saveChartAsJPEG(file, barChart, WIDTH, HEIGHT);
        } catch (final IOException e) {
            throw new SonarAPIRuntimeException(e);
        } catch (final Exception e) {
            throw new SonarAPIRuntimeException(e);
        }

    }

    private String getName() {
        final SimpleDateFormat formatter
            = new SimpleDateFormat("HH.mm.ss.S", Locale.US);
        final String date = formatter.format(new Date());
        return "image".concat(date).concat(".jpeg");
    }

    private CategoryDataset createDataset(
        final Collection<BarChartParameter> parameters) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (final BarChartParameter parameter : parameters) {
            final String name = parameter.getGroup();
            for (final BarChartCategory category : parameter.getCategory()) {
                dataset.addValue(category.getValue(), name, category.getName());
            }
        }
        return dataset;
    }

}
