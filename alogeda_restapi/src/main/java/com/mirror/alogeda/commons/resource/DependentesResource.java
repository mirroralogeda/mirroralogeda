/*package com.mirror.alogeda.commons.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirror.alogeda.commons.helper.responses.ApiResponse;
import com.mirror.alogeda.commons.model.Pessoas;
import com.mirror.alogeda.commons.service.PessoaService;

@Component
@Path("pessoas")
public class DependentesResource {
    @Autowired
    private PessoaService dependentesService;

    @GET
    @Path("getall")
    public Response getAll() {
        return ApiResponse.ok(dependentesService.getAll());
    }

    @GET
    @Path("BuscaPorId")
    public Response BuscaPorId(int dependentesId) {
        return ApiResponse.ok(dependentesService.buscaPorId(dependentesId));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("save")
    public Response save(Dependentes dependentes) {
        dependentesService.save(dependentes);
        return ApiResponse.ok();
    }

}*/
