package com.myapp.config;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

@Component("cacheKeyGenerator")
public class CacheKeyGenerator implements KeyGenerator{

	@Override
	public Object generate(Object target, Method method, Object... params) {
		 final List<Object> key = new ArrayList<>();
	        key.add(method.getDeclaringClass().getName());
	        key.add(method.getName());
	        for (final Object o : params) {
	            key.add(o);
	        }
	        return key;
	}
}
