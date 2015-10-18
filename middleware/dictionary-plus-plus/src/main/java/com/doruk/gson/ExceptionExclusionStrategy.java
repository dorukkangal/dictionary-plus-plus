package com.doruk.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class ExceptionExclusionStrategy implements ExclusionStrategy {

	@Override
	public boolean shouldSkipField(FieldAttributes arg) {
		if (arg.getDeclaringClass().isAssignableFrom(Exception.class)) {
			return !arg.getName().equals("detailMessage");
		}
		return false;
	}

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		return false;
	}
}