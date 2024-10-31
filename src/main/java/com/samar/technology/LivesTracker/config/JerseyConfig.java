package com.samar.technology.LivesTracker.config;



import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("com.samar.technology.LivesTracker.resource"); // Specify the package where your resources are located
    }
}

