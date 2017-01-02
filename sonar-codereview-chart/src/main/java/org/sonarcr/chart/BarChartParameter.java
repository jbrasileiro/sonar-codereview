package org.sonarcr.chart;

import java.util.Collection;

public interface BarChartParameter {

    String getGroup();

    Collection<BarChartCategory> getCategory();
}
