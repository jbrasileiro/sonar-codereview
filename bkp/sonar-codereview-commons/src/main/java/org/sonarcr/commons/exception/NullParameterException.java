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
