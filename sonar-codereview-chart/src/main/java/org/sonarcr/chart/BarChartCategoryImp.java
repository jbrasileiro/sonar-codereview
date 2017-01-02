package org.sonarcr.chart;

public final class BarChartCategoryImp
    implements
    BarChartCategory {

    private final String name;
    private final Number value;

    public BarChartCategoryImp(
        final String name,
        final Number value) {
        super();
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Number getValue() {
        return value;
    }

}
