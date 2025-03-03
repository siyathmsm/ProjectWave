package com.example.project_management;

public class Feed {
    private String feedbackIteration;
    private String groupName;
    private String projectTitle;
    private String docType;
    private String feedBacks;

    public String getFeedbackIteration() {
        return feedbackIteration;
    }

    public void setFeedbackIteration(String feedbackIteration) {
        this.feedbackIteration = feedbackIteration;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getFeedBacks() {
        return feedBacks;
    }

    public void setFeedBacks(String feedBacks) {
        this.feedBacks = feedBacks;
    }
}
