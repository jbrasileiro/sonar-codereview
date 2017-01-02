package org.sonarcr.core.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.sonar.wsclient.issue.Issue;
import org.sonarcr.commons.util.ToStringUtils;
import org.sonarcr.core.enums.TypeIssueSeverity;

public class ProjectIssue {

    private Collection<Issue> blocker;
    private Collection<Issue> critical;
    private Collection<Issue> major;
    private Collection<Issue> minor;
    private Collection<Issue> info;

    public Collection<Issue> getBlocker() {
        return blocker;
    }

    public void setBlocker(
        final Collection<Issue> blocker) {
        this.blocker = blocker;
    }

    public Collection<Issue> getCritical() {
        return critical;
    }

    public void setCritical(
        final Collection<Issue> critical) {
        this.critical = critical;
    }

    public Collection<Issue> getMajor() {
        return major;
    }

    public void setMajor(
        final Collection<Issue> major) {
        this.major = major;
    }

    public Collection<Issue> getMinor() {
        return minor;
    }

    public void setMinor(
        final Collection<Issue> minor) {
        this.minor = minor;
    }

    public Collection<Issue> getInfo() {
        return info;
    }

    public void setInfo(
        final Collection<Issue> info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return ToStringUtils.toString(this);
    }

    public Number getTotalIssue() {
        Integer size = 0;
        size = size + getSize(getBlocker());
        size = size + getSize(getCritical());
        size = size + getSize(getMajor());
        size = size + getSize(getMinor());
        size = size + getSize(getInfo());
        return size;
    }

    private int getSize(
        final Collection<Issue> collection) {
        if (collection == null) {
            return 0;
        } else {
            return collection.size();
        }
    }

    public Collection<Issue> get(
        final TypeIssueSeverity type) {
        switch (type) {
            case BLOCKER:
                return getBlocker();
            case CRITICAL:
                return getCritical();
            case MAJOR:
                return getMajor();
            case MINOR:
                return getMinor();
            case INFO:
                return getInfo();
            default:
                throw new IllegalArgumentException(type.toString());
        }
    }

    public Collection<Issue> getAllIssues() {
        final List<Issue> result = new ArrayList<>();
        for (final TypeIssueSeverity severity : TypeIssueSeverity.values()) {
            result.addAll(get(severity));
        }
        return result;
    }

}
