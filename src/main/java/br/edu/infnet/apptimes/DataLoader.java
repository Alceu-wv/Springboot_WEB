package br.edu.infnet.apptimes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.apptimes.model.domain.Usuario;
import br.edu.infnet.apptimes.model.service.UsuarioService;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setNome("Alceu Colares");
		usuario.setEmail("alceu@alceu.com");
		usuario.setSenha("123");
		usuario.setAdmin(true);
		
		usuarioService.incluir(usuario);

		System.out.println("Inclusão de usuario " + usuario.getNome() + " realizada!!!");
	}
}
