package com.mvpbv.bootutils.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mvpbv.bootutils.model.SolutionModel.SolutionFile;

public class CodeTestsModel {
    @JsonProperty("Readme") 
    public String readme;
    @JsonProperty("ProgLang") 
    public String progLang;
    @JsonProperty("StarterFiles") 
    public ArrayList<StarterModel> starterFiles;
    @JsonProperty("SolutionFiles") 
    public ArrayList<SolutionFile> solutionFiles;
}
