package com.mvpbv.bootutils.models.lesson;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class WorkflowStatusData{

    @Column(name="workflow_name_status")
    @JsonProperty("WorkflowName") 
    public String workflowName;

    @JsonProperty("Status") 
    public String status;
}