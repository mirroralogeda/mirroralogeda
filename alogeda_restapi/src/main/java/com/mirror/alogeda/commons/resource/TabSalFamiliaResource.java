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
import com.mirror.alogeda.commons.model.TabSalFamilia;
import com.mirror.alogeda.commons.service.TabSalFamiliaService;

@Component
@Path("tabsalfamilia")
public class TabSalFamiliaResource {
	@Autowired
	private TabSalFamiliaService tabSalFamiliaService;

	@GET
	@Path("getall")
	public Response getAll() {
		return ApiResponse.ok(tabSalFamiliaService.getAll());
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("save")
	public Response save(TabSalFamilia tabSalFamilia) {
		tabSalFamiliaService.save(tabSalFamilia);
		return ApiResponse.ok();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("delete")
	public Response delete(TabSalFamilia tabSalFamilia) {
		tabSalFamiliaService.delete(tabSalFamilia);
		return ApiResponse.ok();
	}

}

