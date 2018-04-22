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

import com.mirror.alogeda.commons.model.Pessoa;
import com.mirror.alogeda.commons.service.PessoaService;

@Component
@Path("pessoa")
public class PessoaResource {
	@Autowired
	private PessoaService pessoaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getall")
    public List<Pessoa> getAll() {
        return pessoaService.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("save")
    public void save(Pessoa pessoa) {
        pessoaService.save(pessoa);
    }

}
