package org.sonarcr.commons.util;

import org.sonarcr.commons.exception.NoNewInstanceAllowed;

public final class ObjectEqualsUtils {

    private ObjectEqualsUtils() {
        super();
        throw new NoNewInstanceAllowed(getClass());
    }

    public static boolean notEquals(final Object one,
        final Object two) {
        return !isEquals(one, two);
    }
    
    public static boolean isEquals(final Object one,
        final Object two) {
        if (ObjectsUtils.same(one, two)) {
            return true;
        }
        if (ObjectsUtils.xorNull(one, two)
            || !ObjectsUtils.sameClass(one, two)) {
            return false;
        }
        return true;
    }

}
