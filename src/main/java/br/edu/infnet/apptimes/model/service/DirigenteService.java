package br.edu.infnet.apptimes.model.service;

import java.util.List;

import br.edu.infnet.apptimes.model.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apptimes.model.domain.Dirigente;
import br.edu.infnet.apptimes.model.repository.DirigenteRepository;

@Service
public class DirigenteService {
	
	@Autowired
	private DirigenteRepository dirigenteRepository;

	public List<Dirigente> obterLista(){
		return (List<Dirigente>) dirigenteRepository.findAll();
	}

	public List<Dirigente> obterLista(Usuario usuario){
		return (List<Dirigente>) dirigenteRepository.obterLista(usuario.getId());
	}
	
	public void incluir(Dirigente dirigente) {
		dirigenteRepository.save(dirigente);
	}
	
	public void excluir(Integer id) {
		dirigenteRepository.deleteById(id);
	}
	
	public Dirigente obterPorId(Integer id) {
		return dirigenteRepository.findById(id).orElse(null);
	}
}