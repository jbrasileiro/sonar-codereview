/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 * 
 */
package org.sonarcr.commons.exception;

import java.io.File;

public final class FileCanNotBeDeleted
    extends
    SonarAPIRuntimeException {

    private static final long serialVersionUID = 1L;

    public FileCanNotBeDeleted(
        final File file) {
        super("Can not delete file: ".concat(file.getPath()));
    }

}
