package com.csetutorials.multiblogapp.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component("cacheKeyGenerator")
public class CacheKeyGenerator implements KeyGenerator {

	@Override
	public Object generate(Object target, Method method, Object... params) {
		// Exclude certain parameters from generating the cache key
		Object[] cacheParams = Arrays.stream(params)
				.filter(param -> !(param instanceof Model))
				.toArray();

		// Generate cache key based on the remaining parameters
		return Arrays.deepHashCode(cacheParams);
	}
}