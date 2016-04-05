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

@Consumes(MediaType.APPLICATION_JSON)
public class HeartBeatMinionResource {

    MinionController mController;
    public HeartBeatMinionResource() throws IOException{
        mController = new MinionController();
    }

    @POST
    public Response.ResponseBuilder updateHeartbeat(@Valid Heartbeat hb) throws IOException{
        if(mController.saveHB(hb)) return Response.ok();
        else return Response.serverError();
    }
}
