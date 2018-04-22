package com.mirror.alogeda;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.mirror.alogeda.commons.helper.ReflectionHelper;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		super();

		// Registra todas as classes nos pacotes REST
registerPackage("com.mirror.alogeda.commons.resource");
	}

	public void registerPackage(String pkg) {
		for (Class<?> c : ReflectionHelper.getAnnotedClasses(pkg, Component.class))
	register(c);
	}

}
