package br.edu.infnet.apptimes.controller;

import br.edu.infnet.apptimes.model.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.apptimes.model.domain.Jogador;
import br.edu.infnet.apptimes.model.service.JogadorService;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class JogadorController {
	
	@Autowired
	private JogadorService jogadorService;

	@GetMapping(value = "/jogador/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		if (usuario.isAdmin()) {
			model.addAttribute("jogadores", jogadorService.obterLista());
		} else {
			model.addAttribute("jogadores", jogadorService.obterLista(usuario));
		}
		
		return "jogador/lista";
	}	
	
	@GetMapping(value = "/jogador")
	public String telaCadastro() {
		return "jogador/cadastro";
	}
	
	@PostMapping(value = "/jogador/incluir")
	public String incluir(Model model, Jogador jogador, @SessionAttribute("user") Usuario usuario) {

		jogador.setUsuario(usuario);
		
		jogadorService.incluir(jogador);
		
		model.addAttribute("msg", "Jogador " + jogador.getNome() + " cadastrado com sucesso!!!");
		
		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/jogador/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Jogador jogador = jogadorService.obterPorId(id);
		
		jogadorService.excluir(id);
		
		model.addAttribute("msg", "Jogador " + jogador.getNome() + " removido com sucesso!!!");
		
		return telaLista(model, usuario);
	}
}