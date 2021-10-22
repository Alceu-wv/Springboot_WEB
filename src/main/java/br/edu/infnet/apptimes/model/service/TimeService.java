package br.edu.infnet.apptimes.model.service;


import br.edu.infnet.apptimes.model.domain.Tecnico;
import br.edu.infnet.apptimes.model.domain.Time;
import br.edu.infnet.apptimes.model.domain.Usuario;
import br.edu.infnet.apptimes.model.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {
	
	@Autowired
	private TimeRepository timeRepository;

	public List<Time> obterLista(Usuario usuario){
		return (List<Time>) timeRepository.obterLista(usuario.getId());
	}

	public List<Time> obterLista(){
		return (List<Time>) timeRepository.findAll();
	}
	
	public void incluir(Time time) {
		timeRepository.save(time);
	}
	
	public void excluir(Integer id) {
		timeRepository.deleteById(id);
	}

	public Time obterPorId(Integer id) {
		return timeRepository.findById(id).orElse(null);
	}
}