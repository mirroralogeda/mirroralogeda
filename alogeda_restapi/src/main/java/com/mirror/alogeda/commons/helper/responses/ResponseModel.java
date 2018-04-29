package com.mirror.alogeda.commons.helper.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponseModel {
	private StatusResponse status;
	private String message;
	private Object result;

	public ResponseModel() {

	}

	public ResponseModel(StatusResponse status, String message, Object result) {
		this.status = status;
		this.message = message;
		this.result = result;
	}

	public StatusResponse getStatus() {
		return status;
	}

	public void setStatus(StatusResponse status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
