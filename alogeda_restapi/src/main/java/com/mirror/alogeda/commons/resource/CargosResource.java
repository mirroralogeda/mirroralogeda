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
import com.mirror.alogeda.commons.model.Cargos;
import com.mirror.alogeda.commons.service.CargosService;

@Component
@Path("cargos")
public class CargosResource {
    @Autowired
    private CargosService cargoService;

    @GET
    @Path("getall")
    public Response getAll() {
        return ApiResponse.ok(cargoService.getAll());
    }

    @GET
    @Path("BuscaPorId")
    public Response buscaPorId(int entidadeId) {
        return ApiResponse.ok(cargoService.buscaPorId(entidadeId));
    }

    // @GET
    // @Path("CargosAbertos")
    // public Response buscarCargosAbertos(){
        
    // }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("save")
    public Response save(Cargos cargo) {
        cargoService.save(cargo);
        return ApiResponse.ok();
    }

}
