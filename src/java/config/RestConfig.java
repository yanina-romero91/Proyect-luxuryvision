package config;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class RestConfig extends Application {
    // Esto configura el prefijo base para los servicios REST
}
