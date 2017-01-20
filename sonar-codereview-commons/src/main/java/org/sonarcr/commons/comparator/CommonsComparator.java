/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 * 
 */
package org.sonarcr.commons.comparator;

import java.util.Comparator;

public final class CommonsComparator
    implements
    Comparator<Object> {

    @Override
    public int compare(
        final Object o1,
        final Object o2) {
        if (o1 == null ^ o2 == null) {
            return compareNull(o1, o2);
        } else {
            return 0;
        }
    }

    private int compareNull(
        final Object o1,
        final Object o2) {
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return 0;
    }
}
