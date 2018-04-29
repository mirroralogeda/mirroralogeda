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
import com.mirror.alogeda.commons.model.Usuario;
import com.mirror.alogeda.commons.service.UsuarioService;

@Component
@Path("usuario")
public class UsuarioResource {
	@Autowired
	private UsuarioService usuarioService;

	@GET
	@Path("getall")
	public Response getAll() {
		return ApiResponse.ok(usuarioService.getAll());
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("save")
	public Response save(Usuario usuario) {
		usuarioService.save(usuario);
		return ApiResponse.ok();
	}

}
