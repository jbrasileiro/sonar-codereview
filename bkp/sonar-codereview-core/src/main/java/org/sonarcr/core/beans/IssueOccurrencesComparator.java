/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 * 
 */
package org.sonarcr.core.beans;

import java.util.Comparator;

import org.sonarcr.commons.comparator.AbstractComparator;
import org.sonarcr.commons.comparator.CommonsComparator;

public final class IssueOccurrencesComparator
    extends
    AbstractComparator<IssueOccurrences>
    implements
    Comparator<IssueOccurrences> {

    public IssueOccurrencesComparator(
        final CommonsComparator commonsComparator) {
        super(commonsComparator);
    }

    @Override
    protected int compareType(
        final IssueOccurrences one,
        final IssueOccurrences two) {
        final int result = one.getOccurences().compareTo(two.getOccurences());
        if (result == 0) {
            return one.getName().compareTo(two.getName());
        } else {
            return result;
        }
    }
}
