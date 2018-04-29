package com.mirror.alogeda.commons.helper.responses;

import javax.ws.rs.core.MediaType;

public class DefaultResponseBuilder implements ApiResponseBuilder {

	@Override
	public Object getResponse(ResponseModel res) {
return res;
	}

	@Override
	public String getMediaType() {
return MediaType.APPLICATION_JSON;
	}

}
