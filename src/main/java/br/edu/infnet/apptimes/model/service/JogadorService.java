package br.edu.infnet.apptimes.model.service;

import java.util.List;

import br.edu.infnet.apptimes.model.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apptimes.model.domain.Dirigente;
import br.edu.infnet.apptimes.model.domain.Jogador;
import br.edu.infnet.apptimes.model.repository.DirigenteRepository;
import br.edu.infnet.apptimes.model.repository.JogadorRepository;

@Service
public class JogadorService {
	
	@Autowired
	private JogadorRepository jogadorRepository;

	public List<Jogador> obterLista(Usuario usuario){
		return (List<Jogador>) jogadorRepository.obterLista(usuario.getId());
	}

	public List<Jogador> obterLista(){
		return (List<Jogador>) jogadorRepository.findAll();
	}
	
	public void incluir(Jogador jogador) {
		jogadorRepository.save(jogador);
	}
	
	public void excluir(Integer id) {
		jogadorRepository.deleteById(id);
	}
	
	public Jogador obterPorId(Integer id) {
		return jogadorRepository.findById(id).orElse(null);
	}
}