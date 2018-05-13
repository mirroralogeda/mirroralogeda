package com.mirror.alogeda.commons.infra;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

//@Provider
public class JacksonConfig implements ContextResolver<ObjectMapper> {
	final ObjectMapper defaultObjectMapper;

	public JacksonConfig() {
		defaultObjectMapper = createObjectMapper();
	}

	@Override
	public ObjectMapper getContext(Class<?> type) {
return defaultObjectMapper;
	}

	private ObjectMapper createObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new Hibernate5Module());

		return objectMapper;
	}

}
