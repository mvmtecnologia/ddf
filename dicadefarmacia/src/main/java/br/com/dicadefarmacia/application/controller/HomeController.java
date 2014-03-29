package br.com.dicadefarmacia.application.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.dicadefarmacia.infra.constant.URL;
import br.com.dicadefarmacia.infra.constant.View;
import br.com.dicadefarmacia.infra.fake.ContentFake;

/**
 * @author Marcus Soliva - viniciussoliva
 * @author Matheus Cardoso - mtzimba
 * @author Rodolfo Martins - furstmartins
 */
@Controller
@Configuration
@ComponentScan("br.com.dicadefarmacia.service")
public class HomeController {

	@RequestMapping(URL.ROOT)
	public ModelAndView home(HttpServletResponse response) throws IOException {
		return new ModelAndView(View.HOME);
	}
	
	@RequestMapping(URL.LOGIN)
	public ModelAndView login(HttpServletResponse response) throws IOException {
		return new ModelAndView(View.LOGIN);
	}

	@RequestMapping(URL.SEARCH)
	public ModelAndView search(String textsearch) throws IOException {

		ContentFake contentFake = ContentFake.findByName(textsearch);
		System.out.println("contentFake: " + contentFake);
		
		return new ModelAndView(View.LIST_CONTENT, "contentFakes", ContentFake.findAll());
	}

}
