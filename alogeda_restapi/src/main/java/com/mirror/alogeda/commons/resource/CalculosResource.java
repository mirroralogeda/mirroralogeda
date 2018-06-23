package com.mirror.alogeda.commons.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.mirror.alogeda.commons.helper.responses.ApiResponse;
import com.mirror.alogeda.commons.model.viewmodel.CalculoAcessor;
import com.mirror.alogeda.commons.service.CalculosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("calculos")
public class CalculosResource {
	@Autowired
	private CalculosService calcService;

	@POST
	@Path("calcula")
	public Response calcula() {
		calcService.Calcula();
		return ApiResponse.ok();
	}

	@GET
	@Path("getcalculos")
	public Response getCalculos() {
		return ApiResponse.ok(calcService.getPeriodos());
	}

	@POST
	@Path("getfolhas")
	public Response getFolhas(CalculoAcessor calc) {
		return ApiResponse.ok(calcService.getFolhas(calc.getCalculoId()));
	}

}
