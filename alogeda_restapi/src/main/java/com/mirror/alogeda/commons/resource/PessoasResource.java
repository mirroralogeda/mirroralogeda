package com.mirror.alogeda.commons.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirror.alogeda.commons.helper.responses.ApiResponse;
import com.mirror.alogeda.commons.model.Pessoas;
import com.mirror.alogeda.commons.service.PessoaService;

@Component
@Path("pessoas")
public class PessoasResource {
    @Autowired
    private PessoaService pessoaService;

    @GET
    @Path("getall")
    public Response getAll() {
        return ApiResponse.ok(pessoaService.getAll());
    }

    @GET
    @Path("BuscaPorId")
    public Response BuscaPorId(int pessoaId) {
        return ApiResponse.ok(pessoaService.buscaPorId(pessoaId));
    }

    @GET
    @Path("getbycpf")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("cpf") String cpf) {
        return ApiResponse.ok(pessoaService.findByCpf(cpf));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("save")
    public Response save(Pessoas pessoa) {
        pessoaService.save(pessoa);
        return ApiResponse.ok();
    }

}
