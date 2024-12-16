package com.mvpbv.bootutils.models.lesson;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class Step{
    @JsonProperty("StepType") 
    public String stepType;
    @JsonProperty("BranchExistsData") 
    public Object branchExistsData;
    @JsonProperty("PRExistsData") 
    public Object pRExistsData;
    @JsonProperty("WorkflowStatusData") 
    public WorkflowStatusData workflowStatusData;
    @JsonProperty("WorkflowLogsContainsData") 
    public WorkflowLogsContainsData workflowLogsContainsData;
    @JsonProperty("FileContainsData") 
    public Object fileContainsData;
}
