package com.mirror.alogeda.commons.helper;

public final class EntidadeHelper {
	public static void assertExiste(Object ent) {
		if (ent == null)
			throw new NullPointerException("A entidade não foi encontrada.");
	}
}
