package com.driesdejager.tutorial.dropwizard.resources;

import com.driesdejager.tutorial.dropwizard.api.Heartbeat;
import com.driesdejager.tutorial.dropwizard.application.MinionController;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by georgej on 5/04/16.
 */

@Path("/status")
@Produces(MediaType.APPLICATION_JSON)
public class StatusResource {

    MinionController mc;

    public StatusResource() throws IOException{
        mc = new MinionController();
    }

    @GET
    public Heartbeat getMinionStatus(@Valid String id){
        return mc.getMinionHeartbeat(id);
    }
}
