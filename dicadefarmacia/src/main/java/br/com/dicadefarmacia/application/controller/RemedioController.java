package br.com.dicadefarmacia.application.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import br.com.dicadefarmacia.domain.Remedio;
import br.com.dicadefarmacia.domain.Usuario;
import br.com.dicadefarmacia.infra.constant.URL;
import br.com.dicadefarmacia.service.RemedioService;

/**
 * @author Marcus Soliva - viniciussoliva
 * @author Matheus Cardoso - mtzimba
 * @author Rodolfo Martins - furstmartins
 */
@Controller
@Configuration
@ComponentScan("br.com.dicadefarmacia.service")
public class RemedioController {

	@Autowired
	private RemedioService remedioService;

	@RequestMapping(URL.REMEDIO)
	public String listRemedio(Map<String, Object> map) {
		map.put("remedio", new Usuario());
		map.put("remedioLista", remedioService.listRemedio());
		return "remedio";
	}

	@RequestMapping(value = "/remedio/add", method = RequestMethod.POST)
	public String addRemedio(@ModelAttribute("remedio") Remedio remedio,
			BindingResult result) {
		remedioService.addRemedio(remedio);
		return "redirect:/";
	}

	@RequestMapping("/remedio/delete/{remedioId}")
	public String deleteRemedio(@PathVariable("remedioId") Long remedioId) {
		remedioService.removeRemedio(remedioId);
		return "redirect:/";
	}

	@RequestMapping(value = "/remedio/updateRemedio", method = RequestMethod.POST)
	public String update(@ModelAttribute("editRemedio") Remedio remedio,
			BindingResult result, SessionStatus status) {
		// validator.validate(remedio, result);
		System.out.println("----------> " + remedio);
		if (result.hasErrors()) {
			return "editRemedio";
		}
		remedioService.updateRemedio(remedio);
		status.setComplete();
		return "redirect:/remedio";
	}

}
