package com.mirror.alogeda.commons.helper.responses;

import javax.ws.rs.core.Response;

public final class ApiResponse {
	private static ApiResponseBuilder resBuilder = new DefaultResponseBuilder();

	public static void setApiResponseBuilder(ApiResponseBuilder responseBuilder) {
		resBuilder = responseBuilder;
	}

	public static Response ok() {
		return buildOkResponse(new ResponseModel(StatusResponse.SUCCESS, null, null));
	}

	public static Response ok(Object result) {
		return buildOkResponse(new ResponseModel(StatusResponse.SUCCESS, null, result));
	}

	public static Response ok(String message) {
		return buildOkResponse(new ResponseModel(StatusResponse.SUCCESS, message, null));
	}

	public static Response ok(String message, Object result) {
		return buildOkResponse(new ResponseModel(StatusResponse.SUCCESS, message, result));
	}

	public static Response alert() {
		return buildOkResponse(new ResponseModel(StatusResponse.SUCCESS, null, null));
	}

	public static Response alert(Object result) {
		return buildOkResponse(new ResponseModel(StatusResponse.SUCCESS, null, result));
	}

	public static Response alert(String message) {
		return buildOkResponse(new ResponseModel(StatusResponse.SUCCESS, message, null));
	}

	public static Response alert(String message, Object result) {
		return buildOkResponse(new ResponseModel(StatusResponse.SUCCESS, message, result));
	}

	public static Response error() {
		return buildOkResponse(new ResponseModel(StatusResponse.ERROR, null, null));
	}

	public static Response error(String message) {
		return buildOkResponse(new ResponseModel(StatusResponse.ERROR, message, null));
	}

	private static Response buildOkResponse(ResponseModel res) {
		return Response.ok(resBuilder.getResponse(res))
				.type(resBuilder.getMediaType())
				.build();
	}

}
