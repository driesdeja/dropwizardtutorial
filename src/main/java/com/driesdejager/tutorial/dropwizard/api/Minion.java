package com.driesdejager.tutorial.dropwizard.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by driesd on 11/03/16.
 */
public class Minion {
    private String id;
    private String name;
    private String location;

    public Minion (){

    }

    public Minion (String id, String name, String location){
        this.id = id;
        this.name = name;
        this.location = location;
    }

    @JsonProperty
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @JsonProperty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        StringBuffer buff = new StringBuffer();
        buff.append("id: " + this.id + "\n"+"name: " + this.name + "\n"+"location: "+ this.location);
        return buff.toString();
    }

}
