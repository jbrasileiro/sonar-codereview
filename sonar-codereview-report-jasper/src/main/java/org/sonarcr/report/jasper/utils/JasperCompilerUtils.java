/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 * 
 */
package org.sonarcr.report.jasper.utils;

import java.io.File;

public final class JasperCompilerUtils {

    public static File getJasperDirectory() {
        final String directory = System.getProperties().getProperty("user.home");
        return new File(directory.concat("/jrs/jasper"));
    }
}
