package com.csetutorials.multiblogapp.config;

import com.csetutorials.multiblogapp.interceptors.DomainInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new DomainInterceptor())
				.addPathPatterns("/**");
	}
}
