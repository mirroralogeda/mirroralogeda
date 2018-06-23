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
import com.mirror.alogeda.commons.model.AreasAtuacao;
import com.mirror.alogeda.commons.model.Cidades;
import com.mirror.alogeda.commons.service.AreasAtuacaoService;
import com.mirror.alogeda.commons.service.CidadeService;

@Component
@Path("areas_atuacao")
public class AreasAtuacaoResource {
	@Autowired
	private AreasAtuacaoService service;

	@GET
	@Path("getall")
	public Response getAll() {
		return ApiResponse.ok(service.getAll());
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("save")
	public Response save(AreasAtuacao AreasAtuacao) {
		service.save(AreasAtuacao);
		return ApiResponse.ok();
	}

}
