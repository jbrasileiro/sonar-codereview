package org.sonarcr.commons.util;

import org.sonarcr.commons.exception.NoNewInstanceAllowed;
import org.sonarcr.commons.exception.NullParameterException;

public final class ObjectsUtils {

    private ObjectsUtils() {
        super();
        throw new NoNewInstanceAllowed(getClass());
    }

    public static boolean isNull(
        final Object o) {
        return o == null;
    }

    public static boolean notNull(
        final Object o) {
        return !isNull(o);
    }

    public static boolean xor(
        final boolean one,
        final boolean two) {
        return one ^ two;
    }

    /**
     * Exclusive-or ("xor") operator for verify if one of them is NULL
     * 
     * @param one
     *            an object
     * @param two
     *            an object
     * @return {@code true} if exactly one (but not both) of two
     *         arguments is {@code null}
     */
    public static boolean xorNull(
        final Object one,
        final Object two) {
        return xor(ObjectsUtils.isNull(one), ObjectsUtils.isNull(two));
    }

    public static <T> T required(
        final T value) {
        if (ObjectsUtils.isNull(value)) {
            throw new NullParameterException();
        } else {
            return value;
        }
    }

    public static boolean same(
        final Object one,
        final Object two) {
        return one == two;
    }

    public static String toString(
        final Object o) {
        if (ObjectsUtils.isNull(o)) {
            return "";
        } else {
            return o.toString();
        }
    }

    public static boolean sameClass(
        final Object one,
        final Object two) {
        return one.getClass() == two.getClass();
    }
}
