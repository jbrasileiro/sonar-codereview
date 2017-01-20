package org.sonarcr.commons.util;

import org.sonarcr.commons.beans.EnumCodeCatalogable;
import org.sonarcr.commons.beans.Meaningful;
import org.sonarcr.commons.exception.NoNewInstanceAllowed;

public final class EnumsUtils {

    private EnumsUtils() {
        super();
        throw new NoNewInstanceAllowed(getClass());
    }

    public static <E extends Enum<?> & EnumCodeCatalogable<T>, T> boolean hasCode(final E[] enums,
        final T code) {
        ObjectsUtils.required(enums);
        ObjectsUtils.required(code);
        for (E enumm : enums) {
            if (enumm.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    public static <E extends Enum<E> & EnumCodeCatalogable<T>, T> E valueOfCode(final E[] enums,
        final T code) {
        ObjectsUtils.required(enums);
        ObjectsUtils.required(code);
        for (E enumm : enums) {
            if (enumm.getCode().equals(code)) {
                return enumm;
            }
        }
        throw new IllegalArgumentException(code.toString());
    }

    /**
     * @param values
     * @param severity
     * @return
     */
    public static <E extends Enum<?> & Meaningful, T> E valueOfMeaning(final E[] enums,
        final String value) {
        for (E enumm : enums) {
            if (enumm.getMeaning().equals(value)) {
                return enumm;
            }
        }
        throw new IllegalArgumentException(value);
    }

}
