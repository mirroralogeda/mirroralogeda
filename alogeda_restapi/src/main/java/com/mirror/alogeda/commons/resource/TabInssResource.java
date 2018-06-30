package com.mirror.alogeda.commons.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mirror.alogeda.commons.helper.responses.ApiResponse;
import com.mirror.alogeda.commons.model.TabInss;
import com.mirror.alogeda.commons.service.TabInssService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("tabinss")
public class TabInssResource {
	@Autowired
	private TabInssService tabService;

	@GET
	@Path("getall")
	public Response getAll() {
		return ApiResponse.ok(tabService.getAll());
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("save")
	public Response save(List<TabInss> faixas) {
		for (TabInss f : faixas)
			tabService.save(f);
		return ApiResponse.ok();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("delete")
	public Response delete(List<TabInss> faixas) {
		for (TabInss f : faixas)
			tabService.delete(f);
		return ApiResponse.ok();
	}

}
