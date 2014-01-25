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
import org.springframework.web.servlet.ModelAndView;

import br.com.dicadefarmacia.domain.Farmacia;
import br.com.dicadefarmacia.domain.Usuario;
import br.com.dicadefarmacia.infra.constant.View;
import br.com.dicadefarmacia.infra.fake.ContentFake;
import br.com.dicadefarmacia.service.FarmaciaService;

@Controller
@Configuration
@ComponentScan("br.com.dicadefarmacia.service")
public class FarmaciaController {
	
	@Autowired
    private FarmaciaService farmaciaService;
 
    @RequestMapping("/farmacia")
    public String listFarmacia(Map<String, Object> map) {
        map.put("farmacia", new Usuario());
        map.put("farmaciaLista", farmaciaService.listFarmacia());
        return "farmacia";
    }

    
    @RequestMapping(value = "/farmacia/add", method = RequestMethod.POST)
    public String addFarmacia(@ModelAttribute("farmacia") Farmacia farmacia, BindingResult result) {
        farmaciaService.addFarmacia(farmacia);
        return "redirect:/farmacia";
    }
    
 
    @RequestMapping("/farmacia/delete/{farmaciaId}")
    public String deleteFarmacia(@PathVariable("farmaciaId") Long farmaciaId) {
        farmaciaService.removeFarmacia(farmaciaId);
        return "redirect:/farmacia";
    }
    
    @RequestMapping("/farmacia/edit/{farmaciaId}")
    public ModelAndView search(Map<String, Object> map, @PathVariable("farmaciaId") Long farmaciaId) throws IOException {

    	Farmacia farmacia = farmaciaService.buscaFarmacia(farmaciaId);
		System.out.println("Farmacia: " + farmacia);
		return new ModelAndView("farmacia", "farmacia", farmacia);
	}

}
