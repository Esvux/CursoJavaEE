package com.academik.rest;

import com.academik.rest.endpoint.GraduacionEndpoint;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Clase activadora para los servicios REST.
 * @author esvux
 */
@ApplicationPath("api")
public class RESTApplicationActivator extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(GraduacionEndpoint.class);
        return classes;
    }
    
}
