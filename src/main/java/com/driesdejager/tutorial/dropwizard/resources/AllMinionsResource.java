package com.driesdejager.tutorial.dropwizard.resources;

import com.driesdejager.tutorial.dropwizard.api.Heartbeat;
import com.driesdejager.tutorial.dropwizard.api.Minion;
import com.driesdejager.tutorial.dropwizard.application.MinionController;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by georgej on 5/04/16.
 */
@Path("/all-minions")
@Produces(MediaType.APPLICATION_JSON)
public class AllMinionsResource {

    MinionController mc;

    public AllMinionsResource() throws IOException {
        mc = new MinionController();
    }

    @GET
    public ArrayList<Minion> getMinionStatus(@Valid String id){
        return mc.getAllMinions();
    }
}
