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
