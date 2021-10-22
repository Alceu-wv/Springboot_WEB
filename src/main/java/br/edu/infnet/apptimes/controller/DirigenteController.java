package br.edu.infnet.apptimes.controller;

import br.edu.infnet.apptimes.model.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.apptimes.model.domain.Dirigente;
import br.edu.infnet.apptimes.model.service.DirigenteService;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class DirigenteController {
	
	@Autowired
	private DirigenteService dirigenteService;

	@GetMapping(value = "/dirigente/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		if (usuario.isAdmin()) {
			model.addAttribute("dirigentes", dirigenteService.obterLista());
		} else {
			model.addAttribute("dirigentes", dirigenteService.obterLista(usuario));
		}
		return "dirigente/lista";
	}	
	
	@GetMapping(value = "/dirigente")
	public String telaCadastro() {
		return "dirigente/cadastro";
	}
	
	@PostMapping(value = "/dirigente/incluir")
	public String incluir(Model model, Dirigente dirigente, @SessionAttribute("user") Usuario usuario) {

		dirigente.setUsuario(usuario);
		
		dirigenteService.incluir(dirigente);
		
		model.addAttribute("msg", "Dirigente " + dirigente.getNome() + " cadastrado com sucesso!!!");
		
		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/dirigente/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Dirigente dirigente = dirigenteService.obterPorId(id);
		
		dirigenteService.excluir(id);
		
		model.addAttribute("msg", "Dirigente " + dirigente.getNome() + " removido com sucesso!!!");
		
		return telaLista(model, usuario);
	}
}