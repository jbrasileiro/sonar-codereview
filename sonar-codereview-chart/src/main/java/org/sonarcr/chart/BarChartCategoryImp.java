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
