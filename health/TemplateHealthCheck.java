package com.driesdejager.tutorial.dropwizard.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by driesd on 11/03/16.
 */
public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")){
            return Result.unhealthy("Template does not include a name");
        }
        return Result.healthy();
    }
}
