package com.mvpbv.bootutils.models.analytics;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AnalyticsCourse(
    @JsonProperty("courseName") String courseName,
    @JsonProperty("courseIndex") int courseIndex
) {}
