package org.sonarcr.report.utils;

import java.io.File;

public final class JasperCompilerUtils {

    public static File getJasperDirectory() {
        final String directory = System.getProperties().getProperty("user.home");
        return new File(directory.concat("/jrs/jasper"));
    }
}
