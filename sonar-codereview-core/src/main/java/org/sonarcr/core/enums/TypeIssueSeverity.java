package org.sonarcr.core.enums;

import org.sonarcr.core.constants.TypeIssueSeverityConstant;

public enum TypeIssueSeverity {
        BLOCKER(TypeIssueSeverityConstant.NAME_BLOCKER,
            TypeIssueSeverityConstant.LEVEL_BLOCKER),
        CRITICAL(TypeIssueSeverityConstant.NAME_CRITICAL,
            TypeIssueSeverityConstant.LEVEL_CRITICAL),
        MAJOR(TypeIssueSeverityConstant.NAME_MAJOR,
            TypeIssueSeverityConstant.LEVEL_MAJOR),
        MINOR(TypeIssueSeverityConstant.NAME_MINOR,
            TypeIssueSeverityConstant.LEVEL_MINOR),
        INFO(TypeIssueSeverityConstant.NAME_INFO,
            TypeIssueSeverityConstant.LEVEL_INFO),;

    private final String meaning;
    private final int severity;

    private TypeIssueSeverity(
        final String meaning,
        final int severity) {
        this.meaning = meaning;
        this.severity = severity;
    }

    public String getMeaning() {
        return meaning;
    }

    public int getSeverity() {
        return severity;
    }

}