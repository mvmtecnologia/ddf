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

import br.com.dicadefarmacia.domain.Usuario;
import br.com.dicadefarmacia.infra.constant.URL;
import br.com.dicadefarmacia.service.UsuarioService;

/**
 * @author Marcus Soliva - viniciussoliva
 * @author Matheus Cardoso - mtzimba
 * @author Rodolfo Martins - furstmartins
 */
@Controller
@Configuration
@ComponentScan("br.com.dicadefarmacia.service")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(URL.USUARIO)
	public String listUsuarios(Map<String, Object> map) {
		map.put("usuario", new Usuario());
		map.put("usuarioList", usuarioService.listUsuario());
		return "usuario";
	}

	@RequestMapping(value = "/usuario/add", method = RequestMethod.POST)
	public String addUsuario(@ModelAttribute("usuario") Usuario usuario,
			BindingResult result) {
		usuarioService.addUsuario(usuario);
		return "redirect:/";
	}

	@RequestMapping("/usuario/delete/{usuarioId}")
	public String deleteUsuario(@PathVariable("usuarioId") Long usuarioId) {
		usuarioService.removeUsuario(usuarioId);
		return "redirect:/";
	}

	@RequestMapping("/client")
	public String redirecionaCliente() {

		return "client";
	}
}
