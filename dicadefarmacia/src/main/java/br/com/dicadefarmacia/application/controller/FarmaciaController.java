package br.com.dicadefarmacia.application.controller;

import java.io.IOException;
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
import org.springframework.web.servlet.ModelAndView;

import br.com.dicadefarmacia.domain.Farmacia;
import br.com.dicadefarmacia.domain.Usuario;
import br.com.dicadefarmacia.infra.constant.URL;
import br.com.dicadefarmacia.service.FarmaciaService;

/**
 * @author Marcus Soliva - viniciussoliva
 * @author Matheus Cardoso - mtzimba
 * @author Rodolfo Martins - furstmartins
 */
@Controller
@Configuration
@ComponentScan("br.com.dicadefarmacia.service")
public class FarmaciaController {

	@Autowired
	private FarmaciaService farmaciaService;

	@RequestMapping(URL.FARMACIA)
	public String listFarmacia(Map<String, Object> map) {
		map.put("farmacia", new Usuario());
		map.put("farmaciaLista", farmaciaService.listFarmacia());
		return "farmacia";
	}

	@RequestMapping(value = "/farmacia/add", method = RequestMethod.POST)
	public String addFarmacia(@ModelAttribute("farmacia") Farmacia farmacia,
			BindingResult result) {
		farmaciaService.addFarmacia(farmacia);
		return "redirect:/";
	}

	@RequestMapping("/farmacia/delete/{farmaciaId}")
	public String deleteFarmacia(@PathVariable("farmaciaId") Long farmaciaId) {
		farmaciaService.removeFarmacia(farmaciaId);
		return "redirect:/";
	}

	@RequestMapping("/farmacia/edit/{farmaciaId}")
	public ModelAndView search(@PathVariable("farmaciaId") Long farmaciaId)
			throws IOException {

		ModelAndView mav = new ModelAndView("editFarmacia");
		Farmacia farm = farmaciaService.buscaFarmacia(farmaciaId);
		mav.addObject("editFarmacia", farm);
		return mav;
	}

	@RequestMapping(value = "/farmacia/updateFarmacia", method = RequestMethod.POST)
	public String update(@ModelAttribute("editFarmacia") Farmacia farmacia,
			BindingResult result, SessionStatus status) {
		// validator.validate(farmacia, result);
		System.out.println("----------> " + farmacia);
		if (result.hasErrors()) {
			return "editFarmacia";
		}
		farmaciaService.updateFarmacia(farmacia);
		status.setComplete();
		return "redirect:/farmacia";
	}

}
