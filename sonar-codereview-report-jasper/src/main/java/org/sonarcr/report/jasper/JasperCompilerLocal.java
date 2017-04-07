/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 * 
 */
package org.sonarcr.report.jasper;

import java.io.File;

import org.sonarcr.report.jasper.utils.JasperCompilerUtils;

import net.sf.jasperreports.engine.JasperReport;

public final class JasperCompilerLocal
    implements
    JasperCompiler {

    private static final String EXT = ".jrxml";
    private final String jrxml;
    private final File directory;

    public JasperCompilerLocal(
        final String jrxml) {
        this(jrxml, directory());
        
    }
    public JasperCompilerLocal(
        final String jrxml,
        final File directory) {
        super();
        this.jrxml = jrxml;
        this.directory = directory;
    }

    @Override
    public JasperReport compile() {
        final File file = new File(jrxml);
        final String fileName = file.getName();
        if (fileName.endsWith(EXT)) {
            final String name = fileName.replace(EXT, ".jasper");
            final File jasper = new File(directory, name);
            return new JasperCompilerImp(jrxml.replaceAll("\\\\", "\\/"), jasper.getPath().replaceAll("\\\\", "\\/")).compile();
        } else {
            final String message
                = fileName.concat(" dosn't have the file extention: ").concat(EXT);
            throw new IllegalArgumentException(message);
        }
    }
    
    private static File directory() {
        return JasperCompilerUtils.getJasperDirectory();
    }
}
