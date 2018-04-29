package com.mirror.alogeda.commons.helper.responses;

public interface ApiResponseBuilder {
	Object getResponse(ResponseModel res);

	String getMediaType();
}
