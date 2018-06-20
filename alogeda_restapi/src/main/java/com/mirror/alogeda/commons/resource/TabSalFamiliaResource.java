package com.mirror.alogeda.commons.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mirror.alogeda.commons.helper.responses.ApiResponse;
import com.mirror.alogeda.commons.model.TabSalFamilia;
import com.mirror.alogeda.commons.service.TabSalFamiliaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	public Response save(List<TabSalFamilia> faixas) {
		for (TabSalFamilia f : faixas)
			tabSalFamiliaService.save(f);
		return ApiResponse.ok();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("delete")
	public Response delete(List<TabSalFamilia> faixas) {
		for (TabSalFamilia f : faixas)
			tabSalFamiliaService.delete(f);
		return ApiResponse.ok();
	}

}
