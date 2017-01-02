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
