package br.edu.infnet.apptimes.controller;

import br.edu.infnet.apptimes.model.domain.Dirigente;
import br.edu.infnet.apptimes.model.domain.Jogador;
import br.edu.infnet.apptimes.model.domain.Time;
import br.edu.infnet.apptimes.model.domain.Usuario;
import br.edu.infnet.apptimes.model.service.DirigenteService;
import br.edu.infnet.apptimes.model.service.JogadorService;
import br.edu.infnet.apptimes.model.service.TecnicoService;
import br.edu.infnet.apptimes.model.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TimeController {
	
	@Autowired
	private TimeService timeService;
	@Autowired
	private JogadorService jogadorService;
	@Autowired
	private DirigenteService dirigenteService;
	@Autowired
	private TecnicoService tecnicoService;

	@GetMapping(value = "/time/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		if (usuario.isAdmin()) {
			model.addAttribute("times", timeService.obterLista());
		} else {
			model.addAttribute("times", timeService.obterLista(usuario));
		}
		
		return "time/lista";
	}	
	
	@GetMapping(value = "/time")
	public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {

		if (usuario.isAdmin()) {
			model.addAttribute("jogadores", jogadorService.obterLista());
			model.addAttribute("dirigentes", dirigenteService.obterLista());
			model.addAttribute("tecnicos", tecnicoService.obterLista());
		} else {
			model.addAttribute("jogadores", jogadorService.obterLista(usuario));
			model.addAttribute("dirigentes", dirigenteService.obterLista(usuario));
			model.addAttribute("tecnicos", tecnicoService.obterLista(usuario));
		}

		return "time/cadastro";
	}
	
	@PostMapping(value = "/time/incluir")
	public String incluir(Model model, Time time, @RequestParam String[] jogadoresId, @RequestParam String dirigente, @RequestParam String tecnico, @SessionAttribute("user") Usuario usuario) {

		time.setDirigente(dirigenteService.obterPorId(Integer.valueOf(dirigente)));
		time.setTecnico(tecnicoService.obterPorId(Integer.valueOf(tecnico)));

		List<Jogador> jogadores = new ArrayList<Jogador>();
		for(String id : jogadoresId) {
			jogadores.add(jogadorService.obterPorId(Integer.valueOf(id)));
		}
		time.setJogadores(jogadores);

		time.setUsuario(usuario);

		timeService.incluir(time);
		
		model.addAttribute("msg", "Time " + time.getNome() + " cadastrado com sucesso!!!");
		
		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/time/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Time time = timeService.obterPorId(id);
		
		timeService.excluir(id);
		
		model.addAttribute("msg", "Time " + time.getNome() + " removido com sucesso!!!");
		
		return telaLista(model, usuario);
	}
}