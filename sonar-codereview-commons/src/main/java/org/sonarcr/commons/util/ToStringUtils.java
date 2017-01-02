package org.sonarcr.commons.util;

import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.sonarcr.commons.exception.NoNewInstanceAllowed;


public final class ToStringUtils {

    private static final Locale DEFAULT_LOCALE = Locale.US;
    private static final ToStringStyle DEFAULT_STYLE
        = ToStringStyle.SHORT_PREFIX_STYLE;

    private ToStringUtils() {
        super();
        throw new NoNewInstanceAllowed(getClass());
    }

    public static String toString(final Object o) {
        return toString(DEFAULT_STYLE, o);
    }

    public static String toString(final ToStringStyle style,
        final Object o) {
        ObjectsUtils.required(o);
        return ToStringBuilder.reflectionToString(o, style);
    }

    public static String toStringWith(final Object o,
        final Map<String, Object> values) {
        ObjectsUtils.required(o);
        ObjectsUtils.required(values);
        return new ToStringBuilder(o, DEFAULT_STYLE).append(values).toString();
    }

    public static String toStringWith(final ToStringStyle style,
        final Object o,
        final Map<String, Object> values) {
        ObjectsUtils.required(o);
        ObjectsUtils.required(values);
        final ToStringBuilder builder = new ToStringBuilder(o, style);
        for (final Entry<String, Object> entry : values.entrySet()) {
            builder.append(entry.getKey(), entry.getValue());
        }
        return builder.toString();
    }

    public static String toUpperCase(final String value) {
        if (ObjectsUtils.isNull(value)) {
            return null;
        } else {
            return value.toUpperCase(DEFAULT_LOCALE);
        }
    }

    public static String toLowerCase(final String value) {
        if (ObjectsUtils.isNull(value)) {
            return null;
        } else {
            return value.toLowerCase(DEFAULT_LOCALE);
        }
    }
}
