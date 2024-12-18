package com.mvpbv.bootutils.models.lesson;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class WorkflowStatusData{

    @Column(name="workflow_name_status")
    @JsonProperty("WorkflowName") 
    public String workflowName;

    @JsonProperty("Status") 
    public String status;

    public String getWorkflowName() {
        return workflowName;
    }

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}