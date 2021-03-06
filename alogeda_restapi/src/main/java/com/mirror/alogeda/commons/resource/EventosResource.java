package com.mirror.alogeda.commons.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mirror.alogeda.commons.helper.responses.ApiResponse;
import com.mirror.alogeda.commons.model.*;
import com.mirror.alogeda.commons.service.*;

@Component
@Path("eventos")
public class EventosResource {
    @Autowired
    private EventosService Service;

    @GET
    @Path("getall")
    public Response getAll() {
        return ApiResponse.ok(Service.getAll());
    }

    @GET
    @Path("BuscaPorId")
    public Response BuscaPorId(int entidadeId) {
        return ApiResponse.ok(Service.buscaPorId(entidadeId));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("save")
    public Response save(Eventos entidade) {
        Service.save(entidade);
        return ApiResponse.ok();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("delete")
    public Response delete(Eventos entidade) {
        Service.delete(entidade);
        return ApiResponse.ok();
    }
}
