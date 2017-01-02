package org.sonarcr.chart;

import java.util.Collection;

public final class BarChartParameterImp
    implements
    BarChartParameter {

    private final String group;
    private final Collection<BarChartCategory> category;

    public BarChartParameterImp(
        final String group,
        final Collection<BarChartCategory> category) {
        super();
        this.group = group;
        this.category = category;
    }

    @Override
    public String getGroup() {
        return group;
    }

    @Override
    public Collection<BarChartCategory> getCategory() {
        return category;
    }
}
