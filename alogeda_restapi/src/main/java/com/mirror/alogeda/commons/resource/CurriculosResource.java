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
import com.mirror.alogeda.commons.model.Curriculos;
import com.mirror.alogeda.commons.service.CargosService;
import com.mirror.alogeda.commons.service.CurriculosService;

@Component
@Path("curriculos")
public class CurriculosResource {
    @Autowired
    private CurriculosService curriculoService;

    @GET
    @Path("getall")
    public Response getAll() {
        return ApiResponse.ok(curriculoService.getAll());
    }


    @GET
    @Path("BuscaPorId")
    public Response buscaPorId(int entidadeId) {
        return ApiResponse.ok(curriculoService.buscaPorId(entidadeId));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("save")
    public Response save(Curriculos curriculo) {
    	curriculoService.save(curriculo);
        return ApiResponse.ok();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("delete")
    public Response delete(Curriculos curriculo) {
    	curriculoService.delete(curriculo);
        return ApiResponse.ok();
    }

}
