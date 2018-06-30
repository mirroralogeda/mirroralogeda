package com.mirror.alogeda.commons.resource;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirror.alogeda.commons.helper.responses.ApiResponse;
import com.mirror.alogeda.commons.model.Salarios;
import com.mirror.alogeda.commons.model.Funcionarios;
import com.mirror.alogeda.commons.model.Cidades;
import com.mirror.alogeda.commons.service.SalariosService;
import com.mirror.alogeda.commons.service.CidadeService;

@Component
@Path("salarios")
public class SalariosResource {
	@Autowired
	private SalariosService salariosService;

	@GET
	@Path("getall")

	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(@QueryParam("funcionario") int funcionario) {
		return ApiResponse.ok(salariosService.findByFuncionario(funcionario));
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("save/{funcionarioId}")
	public Response save(@PathParam("funcionarioId") int funcionarioId, Salarios salarios) {
		Funcionarios funcionario = new Funcionarios();
		funcionario.setId(funcionarioId);
		salarios.setFuncionarios(funcionario);

		List<Salarios> listaSalarios = salariosService.findByFuncionario(funcionarioId);

		for (Salarios salario : listaSalarios) {
			if (salario.getVigFinal() == null) {
				salario.setVigFinal(new Date());
				salariosService.save(salario);
			}
		}
		salariosService.save(salarios);
		return ApiResponse.ok();
	}

	@POST

	@Consumes(MediaType.APPLICATION_JSON)
	@Path("delete")
	public Response delete(Salarios salarios) {
		salariosService.delete(salarios);
		return ApiResponse.ok();
	}
}
