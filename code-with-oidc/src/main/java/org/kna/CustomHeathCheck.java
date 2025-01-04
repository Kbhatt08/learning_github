package org.kna;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import jakarta.enterprise.context.ApplicationScoped;
@Liveness
@ApplicationScoped
public class CustomHeathCheck implements HealthCheck {

    @ConfigProperty(name="quarkus.application.name")
    String applicationName;

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.up(applicationName);
    }
    
}
