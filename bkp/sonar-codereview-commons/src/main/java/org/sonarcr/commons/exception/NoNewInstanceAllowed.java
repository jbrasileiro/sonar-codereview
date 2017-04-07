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

public final class NoNewInstanceAllowed
    extends
    AssertionError {

    private static final long serialVersionUID = -5659477094372236986L;

    public NoNewInstanceAllowed(
        Class<?> clazz) {
        super("No instances allowed for you! ".concat(clazz.getName()));
    }

}
