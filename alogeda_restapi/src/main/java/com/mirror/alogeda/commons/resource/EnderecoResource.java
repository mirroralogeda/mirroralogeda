package com.mirror.alogeda.commons.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirror.alogeda.commons.model.Endereco;
import com.mirror.alogeda.commons.service.EnderecoService;

@Component
@Path("endereco")
public class EnderecoResource {
	@Autowired
	private EnderecoService enderecoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getall")
    public List<Endereco> getAll() {
        return enderecoService.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("save")
    public void save(Endereco endereco) {
        enderecoService.save(endereco);
    }

}
