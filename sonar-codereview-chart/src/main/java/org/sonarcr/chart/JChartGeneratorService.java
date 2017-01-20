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
import java.util.Collection;

public interface JChartGeneratorService {

    boolean generate(
        final String title,
        final Collection<BarChartParameter> parameters,
        final File directory);
}
