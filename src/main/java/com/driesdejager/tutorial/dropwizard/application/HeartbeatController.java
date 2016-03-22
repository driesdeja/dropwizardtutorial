package com.driesdejager.tutorial.dropwizard.application;

import com.driesdejager.tutorial.dropwizard.api.Minion;

import javax.ws.rs.core.Response;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;

/**
 * Created by georgej on 22/03/16.
 */
public class HeartbeatController {

    MinionController mc;

    public HeartbeatController() throws IOException{
        mc = new MinionController();
    }
    public boolean isMinionRegistered(MinionController minionController, String minionId) {
        boolean registered = false;

        for (String id: minionController.ids){
            if(id.equals(minionId)) registered = true;
        }

        if(registered) return true;
        else return false;
    }

    public boolean saveHeartBeat(Minion minion, Time UTC, String status) throws IOException{
        FileWriter fw = new FileWriter("heatbeat.txt");
        fw.write("~" + minion.getId() + "`" + UTC + "@" + status);
        return true;
    }
}
