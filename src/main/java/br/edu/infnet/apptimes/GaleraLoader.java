package br.edu.infnet.apptimes;

import br.edu.infnet.apptimes.model.domain.Dirigente;
import br.edu.infnet.apptimes.model.domain.Jogador;
import br.edu.infnet.apptimes.model.domain.Tecnico;
import br.edu.infnet.apptimes.model.service.DirigenteService;
import br.edu.infnet.apptimes.model.service.JogadorService;
import br.edu.infnet.apptimes.model.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apptimes.model.domain.Usuario;
import br.edu.infnet.apptimes.model.service.UsuarioService;

@Component
public class GaleraLoader implements ApplicationRunner {
	
	@Autowired
	private DirigenteService dirigenteService;
	@Autowired
	private JogadorService jogadorService;
	@Autowired
	private TecnicoService tecnicoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Dirigente d1 = new Dirigente();
		d1.setNome("Reginaldo Rossi");
		dirigenteService.incluir(d1);

		Tecnico t1 = new Tecnico();
		t1.setNome("Vampeta");
		tecnicoService.incluir(t1);
		
		Jogador j1 = new Jogador();
		j1.setNome("Kevin Durant");
		jogadorService.incluir(j1);
		Jogador j2 = new Jogador();
		j2.setNome("Kobe Bryant");
		jogadorService.incluir(j2);
		Jogador j3 = new Jogador();
		j3.setNome("Lebron James");
		jogadorService.incluir(j3);
		Jogador j4 = new Jogador();
		j4.setNome("Elberth Moraes");
		jogadorService.incluir(j4);
		Jogador j5 = new Jogador();
		j5.setNome("Renan Ferreira");
		jogadorService.incluir(j5);
		Jogador j6 = new Jogador();
		j6.setNome("Ingrid Nogueira");
		jogadorService.incluir(j6);


		System.out.println("Inclusão de Profissionais realizada:");
		for(Jogador j : jogadorService.obterLista()) {
			System.out.println(j.getNome());
		}
		System.out.println(t1.getNome());
		System.out.println(d1.getNome());

	}
}