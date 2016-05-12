package com.driesdejager.tutorial.dropwizard.application;

import com.driesdejager.tutorial.dropwizard.api.Heartbeat;
import com.driesdejager.tutorial.dropwizard.api.Minion;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by driesd on 11/03/16.
 */
public class MinionController {

    MinionData md;

    public MinionController() throws IOException{
        md = new MinionData();
    }

    public Heartbeat getMinionHeartbeat(String id) {
        return md.getMinionHeartbeat(id);
    }

    public Heartbeat getMostRecentHeartbeat(String id){
        return md.getMostRecentHeartbeat(id);
    }

    public ArrayList<Minion> getAllMinions(){
        return md.getAllMinions();
    }

    public boolean isMinionRegistered(Minion minion){
        return md.isMinionRegistered(minion);
    }

    public boolean isMinionRegistered(String id){
        return md.isMinionRegistered(id);
    }

    public boolean registerMinion(Minion minion) throws IOException{
        //register the Minion
        // Where should the minion be "registered"?
        //return the id the application generated for the minion

        // write to file ("minions.txt")
        if(!isMinionRegistered(minion)) return md.registerMinion(minion);
        else return false;
    }


    public boolean saveHB(Heartbeat hb) throws IOException{


        if(isMinionRegistered(hb.getId())){
            System.out.println("minion registered");
            return md.saveHB(hb);
        }
        else System.out.println("minion not registered");

        return false;
    }
}
