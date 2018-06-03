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

@Component
@Path("cbo")
public class CboResource {
    @Autowired
    private CboService cboService;

    @GET
    @Path("getall")
    public Response getAll() {
        return ApiResponse.ok(cboService.getAll());
    }

    @GET
    @Path("BuscaPorId")
    public Response buscaPorId(int entidadeId) {
        return ApiResponse.ok(cboService.buscaPorId(entidadeId));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("save")
    public Response save(Cbo cbo) {
        cboService.save(cbo);
        return ApiResponse.ok();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("delete")
    public Response delete(Cbo cbo) {
        cboService.delete(cbo);
        return ApiResponse.ok();
    }
}
