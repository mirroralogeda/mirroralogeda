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
import com.mirror.alogeda.commons.model.Dependentes;
import com.mirror.alogeda.commons.model.Cidades;
import com.mirror.alogeda.commons.service.DependentesService;
import com.mirror.alogeda.commons.service.CidadeService;

@Component
@Path("dependentes")
public class DependentesResource {
	@Autowired
	private DependentesService dependentesService;

	@GET
	@Path("getall")

	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll( @QueryParam("funcionario")  int funcionario) {
		return ApiResponse.ok(dependentesService.findByFuncionario(funcionario));
	} 

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("save")
	public Response save(Dependentes dependentes) {
		dependentesService.save(dependentes);
		return ApiResponse.ok();
	}
	@POST

	@Consumes(MediaType.APPLICATION_JSON)
	@Path("delete")
	public Response delete( Dependentes dependentes) {
		dependentesService.delete(dependentes);
		return ApiResponse.ok();
	}
}
