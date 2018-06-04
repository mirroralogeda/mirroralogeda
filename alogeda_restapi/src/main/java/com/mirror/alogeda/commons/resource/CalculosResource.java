package com.mirror.alogeda.commons.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirror.alogeda.commons.helper.responses.ApiResponse;
import com.mirror.alogeda.commons.service.CalculosService;

@Component
@Path("calculos")
public class CalculosResource {
	@Autowired
	private CalculosService calcService;

	@GET
	@Path("calcula")
	public Response calcula() {
		return ApiResponse.ok(calcService.Calcula());
	}

}
