package com.driesdejager.tutorial.dropwizard.resources;

import com.driesdejager.tutorial.dropwizard.api.Heartbeat;
import com.driesdejager.tutorial.dropwizard.application.MinionController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created by georgej on 22/03/16.
 */

@Path("/heartbeat")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HeartBeatMinionResource {

    public MinionController mController;
    public HeartBeatMinionResource() throws IOException{
        mController = new MinionController();
    }

    @GET
    public Response getHeartbeat(@PathParam("id")String id){
        if(!mController.getMinionHeartbeat(id).getId().isEmpty()) return Response.ok().build();
        else return Response.serverError().build();
    }

    @POST
    public Response updateHeartbeat(@Valid Heartbeat hb) throws IOException{
        if(mController.saveHB(hb)) {
            return Response.ok(hb, MediaType.APPLICATION_JSON_TYPE).build();
        }
        else return Response.ok("{ \"error\": \"minion isn't registered\" } ", MediaType.APPLICATION_JSON_TYPE).build();
    }
}
