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

import java.util.HashMap;
import java.util.Map;

import org.sonarcr.commons.util.ToStringUtils;

public class IssueOccurrences {

    private final String name;
    private final Integer occurences;

    public IssueOccurrences(
        final String name,
        final Integer occurences) {
        super();
        this.name = name;
        this.occurences = occurences;
    }

    public String getName() {
        return name;
    }

    public Integer getOccurences() {
        return occurences;
    }
    
    
    @Override
    public String toString() {
        final Map<String, Object> map = new HashMap<>();
        map.put("occurences", occurences);
        map.put("name", name);
        return ToStringUtils.toStringWith(this, map);
    }
}
