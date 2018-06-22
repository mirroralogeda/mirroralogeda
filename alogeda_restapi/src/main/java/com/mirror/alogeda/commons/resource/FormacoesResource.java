package com.mirror.alogeda.commons.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirror.alogeda.commons.helper.responses.ApiResponse;
import com.mirror.alogeda.commons.model.Formacoes;
import com.mirror.alogeda.commons.model.Setores;
import com.mirror.alogeda.commons.service.FormacoesService;
import com.mirror.alogeda.commons.service.SetoresService;

@Component
@Path("formacoes")
public class FormacoesResource {
    @Autowired
    private FormacoesService service;

    @GET
    @Path("getall")
    public Response getAll() {
        return ApiResponse.ok(service.getAll());
    }

    @GET
    @Path("BuscaPorId")
    public Response buscaPorId(int entidadeId) {
        return ApiResponse.ok(service.buscaPorId(entidadeId));
    }

    @GET
    @Path("findbycurriculo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCompleto(@QueryParam("id") int id) {
        return ApiResponse.ok(service.findByCurriculo(id));
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("save")
    public Response save(Formacoes formacao) {
    	service.save(formacao);
        return ApiResponse.ok();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("delete")
    public Response delete(Formacoes formacao) {
    	service.delete(formacao);
        return ApiResponse.ok();
    }
}
