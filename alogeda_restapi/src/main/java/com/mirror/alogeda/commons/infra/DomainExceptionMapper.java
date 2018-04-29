package com.mirror.alogeda.commons.infra;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.mirror.alogeda.commons.exceptions.DomainException;
import com.mirror.alogeda.commons.helper.responses.ApiResponse;

@Provider
public class DomainExceptionMapper implements ExceptionMapper<DomainException> {

	@Override
	public Response toResponse(DomainException exception) {
		return ApiResponse.error(exception.getDomainMessage());
	}

}
