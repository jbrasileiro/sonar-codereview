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
