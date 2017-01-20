package org.sonarcr.commons.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.sonarcr.commons.exception.EnumCaseNotImplemented;
import org.sonarcr.commons.exception.NoNewInstanceAllowed;

public final class MapsUtils {

    private MapsUtils() {
        super();
        throw new NoNewInstanceAllowed(getClass());
    }

    public static <K extends Enum<K>, E> E getType(
        final Map<K, E> map,
        final K type) {
        ObjectsUtils.required(map);
        ObjectsUtils.required(type);
        if (map.containsKey(type)) {
            return map.get(type);
        } else {
            throw new EnumCaseNotImplemented(type);
        }
    }

    public static <K, V> Map<K, V> getConcurrentHashMap() {
        return new ConcurrentHashMap<>();
    }
}
