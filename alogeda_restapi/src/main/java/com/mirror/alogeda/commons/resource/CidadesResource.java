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
import com.mirror.alogeda.commons.model.Cidades;
import com.mirror.alogeda.commons.service.CidadeService;

@Component
@Path("cidades")
public class CidadesResource {
	@Autowired
	private CidadeService cidadeService;

	@GET
	@Path("getall")
	public Response getAll() {
		return ApiResponse.ok(cidadeService.getAll());
	}

	@GET
    @Path("BuscaPorId")
    public Response BuscaPorId(int cidadeId) {
        return ApiResponse.ok(cidadeService.buscaPorId(cidadeId));
    }

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("save")
	public Response save(Cidades cidade) {
		cidadeService.save(cidade);
		return ApiResponse.ok();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("delete")
	public Response delete(Cidades cidade) {
		cidadeService.delete(cidade);
		return ApiResponse.ok();
	}

}
