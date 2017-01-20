/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 * 
 */
package org.sonarcr.report.beans;

public class IssueReport {

    private String issueName;
    private Integer occurrences;
    private String iconPath;
    

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
    
    public String getIconPath() {
        return iconPath;
    }
    
    public void setIconPath(
        final String iconPath) {
        this.iconPath = iconPath;
    }
}
