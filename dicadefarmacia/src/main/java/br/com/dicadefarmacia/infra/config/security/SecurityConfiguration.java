package br.com.dicadefarmacia.infra.config.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.headers().disable()
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/resources/**","/").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
 	    .defaultSuccessUrl("/admin")
		.and()
 		.logout().permitAll();

	}
	//TODO:implementação esta em memoria ainda, em breve eu faço a refatoracao pra ir no banco.
	@Autowired
	public void configureGlobal(DataSource dataSource, AuthenticationManagerBuilder auth)throws Exception {
      auth
      .inMemoryAuthentication()
      .withUser("user@gmail.com")
      .password("1234")
      .roles("user");
	}

}
