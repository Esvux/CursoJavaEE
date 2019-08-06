package com.academik.rest.endpoint;

import com.academik.dao.GraduacionDAO;
import com.academik.rest.model.Graduacion;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Endpoint para el recurso graduacion.
 * @author esvux
 */
@Path("/graduaciones")
@Produces(MediaType.APPLICATION_JSON)
public class GraduacionEndpoint {
    
    @Inject
    GraduacionDAO dao;
    
    @GET
    public List<Graduacion> getAllData() {
        List<Graduacion> data = dao.findAll();
        return data;
    }

    @GET
    @Path("detalle/{c}")
    public Graduacion getByCorrelative(@PathParam("c") Long correlativo) {
        Graduacion detail = dao.findById(correlativo);
        return detail;
    }
    
}
