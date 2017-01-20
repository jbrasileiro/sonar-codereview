/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 * 
 */
package org.sonarcr.report.exception;

import org.sonarcr.commons.exception.SonarAPIRuntimeException;

public final class SonarCompilerReportException
    extends
    SonarAPIRuntimeException {

    private static final long serialVersionUID = 4823122039222425477L;

    public SonarCompilerReportException(
        final String message,
        final Exception e) {
        super(message, e);
    }
}
