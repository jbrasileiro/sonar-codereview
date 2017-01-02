package org.sonarcr.report.beans;

public class IssueReport {

    private String issueName;
    private Integer occurrences;

    public IssueReport() {
        super();
    }

    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(
        final String issueName) {
        this.issueName = issueName;
    }

    public Integer getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(
        final Integer occurrences) {
        this.occurrences = occurrences;
    }
}
