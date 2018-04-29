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
import com.mirror.alogeda.commons.model.Cidade;
import com.mirror.alogeda.commons.service.CidadeService;

@Component
@Path("cidade")
public class CidadeResource {
	@Autowired
	private CidadeService cidadeService;

	@GET
	@Path("getall")
	public Response getAll() {
		return ApiResponse.ok(cidadeService.getAll());
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("save")
	public Response save(Cidade cidade) {
		cidadeService.save(cidade);
		return ApiResponse.ok();
	}

}
