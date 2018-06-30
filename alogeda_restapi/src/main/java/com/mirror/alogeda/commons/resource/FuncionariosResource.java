package com.mirror.alogeda.commons.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mirror.alogeda.commons.helper.responses.ApiResponse;
import com.mirror.alogeda.commons.model.*;
import com.mirror.alogeda.commons.service.*;

@Component
@Path("funcionarios")
public class FuncionariosResource {
    @Autowired
    private FuncionariosService Service;

    @GET
    @Path("getall")
    public Response getAll(@QueryParam("nome") String nome) {
        return ApiResponse.ok(Service.findByName(nome));
    }

    @GET
    @Path("BuscaPorId")
    public Response BuscaPorId(@QueryParam("entidadeId") int entidadeId) {
        return ApiResponse.ok(Service.buscaId(entidadeId));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("save")
    public Response save(Funcionarios entidade) {
        Service.save(entidade);
        return ApiResponse.ok();
    }

    @GET
    @Path("findAll")
    public Response findAll() {
        List<Funcionarios> funcionarios = Service.getAll();
        for (Funcionarios funcionario : funcionarios) {
            funcionario.getPessoas();
        }
        return ApiResponse.ok(funcionarios);
    }
}
