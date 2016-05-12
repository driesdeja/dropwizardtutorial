package com.driesdejager.tutorial.dropwizard.api;

/**
 * Created by georgej on 11/05/16.
 */
public class RecentHeartbeat {


    public RecentHeartbeat(String id, String time) {
        this.id = id;
        this.time = time;
    }

    public String getMinion() {
        return id;
    }

    public void setMinion(String minion) {
        this.id = minion;
    }

    String id;

    public String getRecent() {
        return time;
    }

    public void setRecent(String recent) {
        this.time = recent;
    }

    String time;


}
