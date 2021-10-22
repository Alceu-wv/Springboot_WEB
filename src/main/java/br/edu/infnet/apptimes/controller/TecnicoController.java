package br.edu.infnet.apptimes.controller;

import br.edu.infnet.apptimes.model.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.apptimes.model.domain.Tecnico;
import br.edu.infnet.apptimes.model.service.TecnicoService;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class TecnicoController {
	
	@Autowired
	private TecnicoService tecnicoService;

	@GetMapping(value = "/tecnico/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		if (usuario.isAdmin()) {
			model.addAttribute("tecnicos", tecnicoService.obterLista());
		} else {
			model.addAttribute("tecnicos", tecnicoService.obterLista(usuario));
		}
		
		return "tecnico/lista";
	}	
	
	@GetMapping(value = "/tecnico")
	public String telaCadastro() {
		return "tecnico/cadastro";
	}
	
	@PostMapping(value = "/tecnico/incluir")
	public String incluir(Model model, Tecnico tecnico, @SessionAttribute("user") Usuario usuario) {

		tecnico.setUsuario(usuario);
		
		tecnicoService.incluir(tecnico);
		
		model.addAttribute("msg", "Tecnico " + tecnico.getNome() + " cadastrado com sucesso!!!");
		
		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/tecnico/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Tecnico tecnico = tecnicoService.obterPorId(id);
		
		tecnicoService.excluir(id);
		
		model.addAttribute("msg", "Técnico " + tecnico.getNome() + " removido com sucesso!!!");
		
		return telaLista(model, usuario);
	}
}