package org.sonarcr.chart;

import java.io.File;
import java.util.Collection;

public interface JChartGeneratorService {

    boolean generate(
        final String title,
        final Collection<BarChartParameter> parameters,
        final File directory);
}
