package com.driesdejager.tutorial.dropwizard.resources;

import com.driesdejager.tutorial.dropwizard.api.Minion;
import com.driesdejager.tutorial.dropwizard.api.RecentHeartbeat;
import com.driesdejager.tutorial.dropwizard.api.Saying;
import com.driesdejager.tutorial.dropwizard.application.MinionController;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by georgej on 11/05/16.
 */
@Path("/recent")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RecentHeartBeatResource {
    MinionController mc;
    ArrayList<RecentHeartbeat> rhb;

    public RecentHeartBeatResource() throws IOException{
        mc = new MinionController();
    }


    @GET
    public ArrayList<RecentHeartbeat> getRecentHeartbeats(){
        for (Minion minion: mc.getAllMinions()){
            rhb.add(new RecentHeartbeat(minion.getId(), mc.getMostRecentHeartbeat(minion.getId()).getTime()));
        }

        return rhb;
    }

    public String getHello(@Valid String message){
        return message;
    }
}
