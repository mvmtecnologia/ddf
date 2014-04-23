package br.com.dicadefarmacia.application.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import br.com.dicadefarmacia.infra.utils.StringUtils;
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
	public String listRemedio(String textsearch, Map<String, Object> map) {
		List<RemedioFarmaciaDTO> listaRemedio = remedioService.getRemedio(textsearch);
		map.put("remedioList", listaRemedio);
		if (listaRemedio != null) {
			Set<String> listaForma = new HashSet<>();
			Set<String> listaDosagem = new HashSet<>();
			Set<String> listaLaboratorio = new HashSet<>();
			
			for(RemedioFarmaciaDTO dto : listaRemedio) {
				listaForma.add(dto.getForma());
				listaDosagem.add(dto.getDosagem());
				listaLaboratorio.add(dto.getNomeFabricante());
			}
			
			map.put("listaForma", listaForma);
			map.put("listaDosagem", listaDosagem);
			map.put("listaLaboratorio", listaLaboratorio);
			
			if (listaRemedio.size() > 1) {
				RemedioFarmaciaDTO rem2 = listaRemedio.get(listaRemedio.size()-1);
				map.put("valorFinal", new Double(Math.ceil(rem2.getPreco())).intValue());
			}
		}
		return View.LIST_CONTENT;
	}

	@RequestMapping(URL.FILTRO)
	public String filtroRemedio(String textsearch, String forma, String dosagem, String laboratorio, 
					String valorMinimo, String valorMaximo, Map<String, Object> map) {
		
		String[] formaArray = null;
		String[] dosagemArray = null;
		String[] laboratorioArray = null;
		Double vlrMin = 0D;
		Double vlrMax = 0D;
		
		if (StringUtils.isNotBlank(forma)) {
			formaArray = forma.split(",");
		}
		if (StringUtils.isNotBlank(dosagem)) {
			dosagemArray = dosagem.split(",");
		}
		if (StringUtils.isNotBlank(laboratorio)) {
			laboratorioArray = laboratorio.split(",");
		}
		if (StringUtils.isNotBlank(valorMinimo)) {
			vlrMin = new Double(valorMinimo);
		}
		if (StringUtils.isNotBlank(valorMaximo)) {
			vlrMax = new Double(valorMaximo);
		}

		List<RemedioFarmaciaDTO> listaRemedio = remedioService.getRemedio(textsearch, formaArray, 
				dosagemArray, laboratorioArray, vlrMin, vlrMax);

		map.put("remedioList", listaRemedio);
		return View.LIST_CONTENT;
	}
	
}
