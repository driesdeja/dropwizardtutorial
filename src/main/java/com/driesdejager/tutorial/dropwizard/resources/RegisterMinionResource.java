package com.driesdejager.tutorial.dropwizard.resources;

import com.driesdejager.tutorial.dropwizard.api.Minion;
import com.driesdejager.tutorial.dropwizard.application.MinionController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by driesd on 11/03/16.
 */


@Path("/register")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RegisterMinionResource {
    private static Logger logger = LoggerFactory.getLogger(RegisterMinionResource.class);

    public RegisterMinionResource(){

    }

    @GET
    public String checkIfRegistered(@PathParam("id")String minionId){
        logger.debug("checkIfRegistered");
        //Validate if the id has previously been registered
        MinionController controller = new MinionController();

        if (controller.isMinionRegistered(minionId)){
            return "200";
        } else {
            return "404";
        }

    }

    @POST
    public Response registerMinion(@Valid  Minion minion){
        logger.debug("registerMinion");
        //What steps should happen when we register a new minion?
        //Step 1: Check to see if the Minion is already registered...
        MinionController controller = new MinionController();
        if (!controller.isMinionRegistered(minion)){
            //Step 2: ...
            controller.registerMinion(minion);
            //how to we add JSON to the response?
            return Response.ok(minion, MediaType.APPLICATION_JSON_TYPE).build();
        } else {

            return Response.ok("{ \"error\": \"Minion already registered\" } ", MediaType.APPLICATION_JSON_TYPE).build();
        }

    }
}
