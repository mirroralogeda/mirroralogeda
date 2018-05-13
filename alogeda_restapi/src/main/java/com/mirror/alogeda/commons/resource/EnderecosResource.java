package com.mirror.alogeda.commons.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirror.alogeda.commons.exceptions.DomainException;
import com.mirror.alogeda.commons.helper.responses.ApiResponse;
import com.mirror.alogeda.commons.model.Enderecos;
import com.mirror.alogeda.commons.service.EnderecoService;

@Component
@Path("enderecos")
public class EnderecosResource {
	@Autowired
	private EnderecoService enderecoService;

    @GET
    @Path("getall")
    public Response getAll() {
        return ApiResponse.ok(enderecoService.getAll());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("save")
    public Response save(Enderecos endereco) {
        enderecoService.save(endereco);
        return ApiResponse.ok();
    }
    
}
