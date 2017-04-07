/**
 * 
 */
package org.sonarcr.report.commons.commons;

import java.io.File;

import org.sonarcr.commons.resources.ResourceLoader;

/**
 * @author joao.almeida
 *
 */
public class ReportResourceLoader {

    /**
     * @param string
     * @param name
     * @return
     */
    public static File loadFrom(
        final String directory,
        final String name) {
        return ResourceLoader.loadFrom(ReportResourceLoader.class, directory, name);
    }
}
