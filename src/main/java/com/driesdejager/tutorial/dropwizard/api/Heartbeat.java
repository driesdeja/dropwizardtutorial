package com.driesdejager.tutorial.dropwizard.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by georgej on 23/03/16.
 */
public class Heartbeat {
    private String id;
    private String time;

    @JsonProperty
    public String getTime() {
        return time;
    }
    @JsonProperty
    public void setTime(String time) {
        this.time = time;
    }
    @JsonProperty
    public String getId() {
        return id;
    }
    @JsonProperty
    public void setId(String id) {
        this.id = id;
    }

}
