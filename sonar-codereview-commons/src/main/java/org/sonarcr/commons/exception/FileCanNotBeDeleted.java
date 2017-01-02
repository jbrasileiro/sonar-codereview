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
