package br.com.dicadefarmacia.infra.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import br.com.dicadefarmacia.infra.config.database.DatabaseConfiguration;
import br.com.dicadefarmacia.infra.config.mvc.MvcConfiguration;

@org.springframework.context.annotation.Configuration
@Import({DatabaseConfiguration.class,
	     MvcConfiguration.class})
@ComponentScan(basePackages={"br.com.dicadefarmacia"})

public class AppConfiguration  {


	@Bean
	public MessageSource reloadableResourceBundleMessageSource(){
		ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
		bundleMessageSource.setBasename("classpath:messages");
		bundleMessageSource.setCacheSeconds(1000*60);
		bundleMessageSource.setDefaultEncoding("UTF-8");
		return bundleMessageSource;
	}



}
