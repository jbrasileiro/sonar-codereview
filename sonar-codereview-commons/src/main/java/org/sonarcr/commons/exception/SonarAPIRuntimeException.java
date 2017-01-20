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

public class SonarAPIRuntimeException
    extends
    RuntimeException {

    private static final long serialVersionUID = 8152641910129991494L;

    public SonarAPIRuntimeException(
        final String message,
        final Throwable cause) {
        super(message, cause);
    }

    public SonarAPIRuntimeException(
        final String message) {
        super(message);
    }

    public SonarAPIRuntimeException(
        final Throwable cause) {
        super(cause);
    }

}
