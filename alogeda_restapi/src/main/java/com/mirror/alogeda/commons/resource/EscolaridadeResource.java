package com.mirror.alogeda.commons.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirror.alogeda.commons.helper.responses.ApiResponse;
import com.mirror.alogeda.commons.model.Cbo;
import com.mirror.alogeda.commons.service.CboService;
import com.mirror.alogeda.commons.service.EscolaridadeService;

@Component
@Path("escolaridade")
public class EscolaridadeResource {
    @Autowired
    private EscolaridadeService escolaridadeService;

    @GET
    @Path("getall")
    public Response getAll() {
        return ApiResponse.ok(escolaridadeService.getAll());
    }

    @GET
    @Path("BuscaPorId")
    public Response buscaPorId(int id) {
        return ApiResponse.ok(escolaridadeService.buscaPorId(id));
    }
 
}
