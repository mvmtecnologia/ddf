package br.com.dicadefarmacia.application.controller;

import java.io.IOException;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.dicadefarmacia.domain.Usuario;
import br.com.dicadefarmacia.infra.constant.URL;
import br.com.dicadefarmacia.infra.constant.View;

/**
 * @author Marcus Soliva - viniciussoliva
 * @author Matheus Cardoso - mtzimba
 * @author Rodolfo Martins - furstmartins
 */
@Controller
@Configuration
@ComponentScan("br.com.dicadefarmacia.service")
public class LoginController {

	@RequestMapping(value = URL.ADMIN, method = RequestMethod.POST)
	public ModelAndView admin(@ModelAttribute("usuario") Usuario usuario) throws IOException {
		return new ModelAndView(View.ADMIN);
		//return new ModelAndView(View.ADMIN_FARMACIA);
	}
}