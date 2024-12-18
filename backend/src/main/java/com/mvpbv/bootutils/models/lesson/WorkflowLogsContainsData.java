package com.mvpbv.bootutils.models.lesson;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;


@Embeddable


public class WorkflowLogsContainsData{
    @JsonProperty("WorkflowName") 
    public String workflowName;
    @JsonProperty("Jobs") 
    public Jobs jobs;

    public String getWorkflowName() {
        return workflowName;
    }

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }
}