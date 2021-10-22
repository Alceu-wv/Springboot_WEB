package br.edu.infnet.apptimes.model.service;

import java.util.List;

import br.edu.infnet.apptimes.model.domain.Dirigente;
import br.edu.infnet.apptimes.model.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apptimes.model.domain.Tecnico;
import br.edu.infnet.apptimes.model.repository.TecnicoRepository;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;

	public List<Tecnico> obterLista(Usuario usuario){
		return (List<Tecnico>) tecnicoRepository.obterLista(usuario.getId());
	}

	public List<Tecnico> obterLista(){
		return (List<Tecnico>) tecnicoRepository.findAll();
	}
	
	public void incluir(Tecnico tecnico) {
		tecnicoRepository.save(tecnico);
	}
	
	public void excluir(Integer id) {
		tecnicoRepository.deleteById(id);
	}
	
	public Tecnico obterPorId(Integer id) {
		return tecnicoRepository.findById(id).orElse(null);
	}
}