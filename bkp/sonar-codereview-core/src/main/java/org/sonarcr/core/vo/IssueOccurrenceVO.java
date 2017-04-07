/**
 * 
 */
package org.sonarcr.core.vo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.sonarcr.commons.util.ObjectEqualsUtils;
import org.sonarcr.commons.util.ToStringUtils;
import org.sonarcr.core.enums.TypeIssueSeverity;

public final class IssueOccurrenceVO {

    private final String name;
    private final TypeIssueSeverity severity;
    private Integer occurrencies;

    public IssueOccurrenceVO(
        final String name,
        final TypeIssueSeverity severity,
        final Integer occurrencies) {
        super();
        this.name = name;
        this.severity = severity;
        this.occurrencies = occurrencies;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @return
     */
    public TypeIssueSeverity getSeverity() {
        return severity;
    }

    /**
     * @return
     */
    public Integer getOccurrence() {
        return occurrencies;
    }

    @Override
    public boolean equals(
        final Object obj) {
        if (ObjectEqualsUtils.isEquals(this, obj) && obj instanceof IssueOccurrenceVO) {
            EqualsBuilder builder = new EqualsBuilder();
            IssueOccurrenceVO o = (IssueOccurrenceVO) obj;
            builder.append(this.name, o.name);
            builder.append(this.severity, o.severity);
            return builder.isEquals();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(this.name);
        builder.append(this.severity);
        return builder.hashCode();
    }

    @Override
    public String toString() {
        return ToStringUtils.toString(this);
    }

    /**
     * @return
     */
    public void increase() {
        this.occurrencies++;
    }
}
