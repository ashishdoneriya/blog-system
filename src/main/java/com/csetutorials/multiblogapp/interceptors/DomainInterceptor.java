package com.csetutorials.multiblogapp.interceptors;

import com.csetutorials.multiblogapp.utilities.DomainResolver;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DomainInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		DomainResolver.setDomain(request.getServerName());
		return true;
	}
}