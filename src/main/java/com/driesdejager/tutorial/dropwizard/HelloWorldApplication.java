package com.driesdejager.tutorial.dropwizard;

import com.driesdejager.tutorial.dropwizard.health.TemplateHealthCheck;
import com.driesdejager.tutorial.dropwizard.resources.HeartBeatMinionResource;
import com.driesdejager.tutorial.dropwizard.resources.HelloWorldResource;
import com.driesdejager.tutorial.dropwizard.resources.RegisterMinionResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.io.IOException;

/**
 * Created by driesd on 10/03/16.
 */
public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName(){
        return "hello-world";
    }
    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap){

    }

    @Override
    public void run (HelloWorldConfiguration configuration, Environment environment) throws IOException {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final RegisterMinionResource registerMinionResource = new RegisterMinionResource();
        environment.jersey().register(registerMinionResource);
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);

        final HeartBeatMinionResource heartBeatMinionResource = new HeartBeatMinionResource();
        environment.jersey().register(heartBeatMinionResource);


    }




}

