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

public abstract class AbstractComparator<T>
    implements
    Comparator<T> {

    private final CommonsComparator commonsComparator;

    public AbstractComparator(
        final CommonsComparator commonsComparator) {
        super();
        this.commonsComparator = commonsComparator;
    }

    @Override
    public int compare(
        final T one,
        final T two) {
        final int result = commonsComparator.compare(one, two);
        if (result == 0) {
            return compareType(one, two);
        } else {
            return result;
        }
    }

    protected abstract int compareType(
        final T one,
        final T two);
}
