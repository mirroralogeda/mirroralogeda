package com.mirror.alogeda.commons.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.mirror.alogeda.commons.helper.responses.ApiResponse;
import com.mirror.alogeda.commons.model.ParametrosFolha;
import com.mirror.alogeda.commons.model.viewmodel.CalculoAcessor;
import com.mirror.alogeda.commons.service.CalculosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	@GET
	@Path("getperiodos")
	public Response getPeriodos() {
		return ApiResponse.ok(calcService.getPeriodos());
	}

	@POST
	@Path("getcalculosperiodo")
	public Response getCalculosPeriodo(ParametrosFolha parametro) {
		return ApiResponse.ok(calcService.getCalculosPeriodo(parametro));
	}

	@POST
	@Path("getfuncionarioscalculo")
	public Response getFuncionariosCalculo(CalculoAcessor calc) {
		return ApiResponse.ok(calcService.getFuncionariosCalculo(calc.getDataCalculo()));
	}

}
