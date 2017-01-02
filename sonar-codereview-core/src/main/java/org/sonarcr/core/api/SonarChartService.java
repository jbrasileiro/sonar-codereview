package org.sonarcr.core.api;

import java.io.File;
import java.util.Collection;

public interface SonarChartService {

    boolean generateChart(
        String url,
        String id,
        File directory);

    boolean generateChart(
        String url,
        Collection<String> id,
        File directory);
}
