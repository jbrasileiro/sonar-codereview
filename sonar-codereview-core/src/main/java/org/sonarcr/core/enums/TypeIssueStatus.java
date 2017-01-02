package org.sonarcr.core.enums;

public enum TypeIssueStatus {
        OPEN("OPEN"),
        REOPENED("REOPENED"),
        CONFIRMED("CONFIRMED"),
        RESOLVED("RESOLVED"),
        CLOSED("CLOSED"),;

    private final String meaning;

    private TypeIssueStatus(
        final String meaning) {
        this.meaning = meaning;
    }

    public String getMeaning() {
        return meaning;
    }

}
