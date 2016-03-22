package com.driesdejager.tutorial.dropwizard.resources;

import com.driesdejager.tutorial.dropwizard.api.Minion;
import com.driesdejager.tutorial.dropwizard.application.HeartbeatController;
import com.driesdejager.tutorial.dropwizard.application.MinionController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.Time;

/**
 * Created by georgej on 22/03/16.
 */

@Path("/heartbeat")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HeartBeatMinionResource {
    private static Logger logger = LoggerFactory.getLogger(RegisterMinionResource.class);

    HeartbeatController hController;
    public HeartBeatMinionResource(){
        hController = new HeartbeatController();
    }

    public Response.ResponseBuilder checkIfRegistered(@PathParam("id")String minionId, MinionController mc) throws IOException {
        logger.debug("checkIfRegistered");
        HeartbeatController controller = new HeartbeatController();

        if (controller.isMinionRegistered(mc, minionId)){
            return Response.ok();
        } else {
            return Response.serverError();
        }

    }

    @POST
    public Response.ResponseBuilder updateHeartbeat(@Valid Minion minion) throws IOException{
//        checkIfRegistered(minion.getId(), new MinionController());
        Time time = new Time();
        time.setTime(429029);
        if(hController.saveHeartBeat(minion, time, "200")) return Response.ok();
        else return Response.serverError();
    }
}
