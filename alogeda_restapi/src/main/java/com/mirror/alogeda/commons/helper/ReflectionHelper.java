package com.mirror.alogeda.commons.helper;

import java.lang.annotation.Annotation;

import org.reflections.Reflections;

public final class ReflectionHelper {
	public static Iterable<Class<?>> getAnnotedClasses(String pkg, Class<? extends Annotation> annotation) {
		Reflections r = new Reflections(pkg);
		return r.getTypesAnnotatedWith(annotation);
	}
}
