package br.com.dicadefarmacia.application.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.dicadefarmacia.dto.RemedioFarmaciaDTO;
import br.com.dicadefarmacia.infra.constant.URL;
import br.com.dicadefarmacia.infra.constant.View;
import br.com.dicadefarmacia.infra.fake.ContentFake;
import br.com.dicadefarmacia.service.RemedioService;

/**
 * @author Marcus Soliva - viniciussoliva
 * @author Matheus Cardoso - mtzimba
 * @author Rodolfo Martins - furstmartins
 */
@Controller
@Configuration
@ComponentScan("br.com.dicadefarmacia.service")
public class HomeController {

	@Autowired
	private RemedioService remedioService;
	
	@RequestMapping(URL.HOME)
	public ModelAndView home(HttpServletResponse response) throws IOException {
		return new ModelAndView(View.HOME);
	}
	
	@RequestMapping(URL.LOGIN)
	public ModelAndView login(HttpServletResponse response) throws IOException {
		return new ModelAndView(View.LOGIN);
	}

	@RequestMapping(URL.SEARCH)
	public ModelAndView search(String textsearch) throws IOException {
		List<RemedioFarmaciaDTO> listaRemedio = remedioService.getRemedio(textsearch);
		if (listaRemedio != null && listaRemedio.size() > 2) {
			RemedioFarmaciaDTO rem1 = listaRemedio.get(0);
			RemedioFarmaciaDTO rem2 = listaRemedio.get(listaRemedio.size()-1);
			System.out.println(rem2.getPreco() - rem1.getPreco());
		}
		return new ModelAndView(View.LIST_CONTENT, "remedioList", listaRemedio);
	}

}
