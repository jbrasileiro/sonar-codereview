package org.sonarcr.commons.exception;

public class NullParameterException
    extends
    IllegalArgumentException {

    private static final long serialVersionUID = -1571741950679460515L;

    public NullParameterException(
        Class<?> clazz) {
        this("Required: ".concat(clazz.getName()));
    }
    
    public NullParameterException() {
        this("");
    }

    private NullParameterException(
        String detail) {
        super("Parameter can't be null. ".concat(detail));
    }


}
