package quarkus.projects.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "project-service")
public interface ProjectServiceConfigMapping {
    
    @ConfigProperty(name="client-name")
    String clientName();

}
