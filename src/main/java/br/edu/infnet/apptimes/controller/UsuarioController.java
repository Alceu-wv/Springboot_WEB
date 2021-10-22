package br.edu.infnet.apptimes.controller;

import br.edu.infnet.apptimes.model.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.apptimes.model.domain.Endereco;
import br.edu.infnet.apptimes.model.domain.Usuario;
import br.edu.infnet.apptimes.model.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private TimeService timeService;

	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "usuario/cadastro";
	}
	
	@GetMapping(value = "/usuario/lista")
	public String telaLista(Model model) {

		model.addAttribute("lista", usuarioService.obterLista());

		model.addAttribute("times", timeService.obterLista());

		return "usuario/lista";
	}

	@PostMapping(value = "/usuario")
	public String incluir(Usuario usuario, Endereco endereco) {
		
		usuario.setEndereco(endereco);
		
		usuarioService.incluir(usuario);
		
		return "redirect:/";
	}

	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {

		usuarioService.excluir(id);
		
		return "redirect:/usuario/lista";
	}
}