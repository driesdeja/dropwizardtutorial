package com.driesdejager.tutorial.dropwizard.application;

import com.driesdejager.tutorial.dropwizard.api.Minion;

/**
 * Created by driesd on 11/03/16.
 */
public class MinionController {

    public boolean isMinionRegistered(Minion minion){
        return false;
    }
    public boolean isMinionRegistered(String minionId){
        return false;
    }

    /**
     * registerMinion
     * Used to register the minion, it creates a unique id for the minion and stores the id sent with the id received...
     * @param minion
     * @return
     */


    public Minion registerMinion(Minion minion) {
        //register the Minion
        // Where should the minion be "registered"?
        //return the id the application generated for the minion
        return minion;
    }
}
