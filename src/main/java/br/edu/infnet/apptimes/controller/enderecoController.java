package br.edu.infnet.apptimes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.apptimes.model.domain.Endereco;
import br.edu.infnet.apptimes.model.service.EnderecoService;

@Controller
public class enderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	
	@PostMapping(value= "/cep")
	public String obterCep(Model model, @RequestParam String cep) {

		if(cep == null || cep.length() < 8) {
			model.addAttribute("mensagem", "Insira um endereço válido");
			return "usuario/cadastro";
		}
		
		Endereco endereco = enderecoService.obterPorCep(cep);
		
		model.addAttribute("endereco", endereco);
		
		
		return "usuario/cadastro";
	}
}
