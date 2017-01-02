package org.sonarcr.commons.exception;

public final class NoNewInstanceAllowed
    extends
    AssertionError {

    private static final long serialVersionUID = -5659477094372236986L;

    public NoNewInstanceAllowed(
        Class<?> clazz) {
        super("No instances allowed for you! ".concat(clazz.getName()));
    }

}
