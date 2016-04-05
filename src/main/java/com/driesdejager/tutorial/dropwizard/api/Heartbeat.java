package com.driesdejager.tutorial.dropwizard.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by georgej on 23/03/16.
 */
public class Heartbeat {
    private String id;
    private long time;

    @JsonProperty
    public long getTime() {
        return time;
    }
    @JsonProperty
    public void setTime(long time) {
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
