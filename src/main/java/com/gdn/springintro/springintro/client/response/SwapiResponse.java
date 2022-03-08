package com.gdn.springintro.springintro.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiResponse {

    private Integer count;
    private List<SwapiMovie> results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<SwapiMovie> getResults() {
        return results;
    }

    public void setResults(List<SwapiMovie> results) {
        this.results = results;
    }
}
