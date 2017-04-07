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
