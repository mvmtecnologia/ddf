package br.com.dicadefarmacia.infra.config.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class SecurityWebApplicationInitializer  extends AbstractSecurityWebApplicationInitializer{

	public SecurityWebApplicationInitializer() {
		super(SecurityWebApplicationInitializer.class);
	}
	
	@Override
	protected String getDispatcherWebApplicationContextSuffix() {
		return AbstractDispatcherServletInitializer.DEFAULT_SERVLET_NAME;
	}
}
