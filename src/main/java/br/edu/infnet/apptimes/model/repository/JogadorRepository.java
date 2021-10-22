package br.edu.infnet.apptimes.model.repository;

import br.edu.infnet.apptimes.model.domain.Dirigente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apptimes.model.domain.Jogador;

import java.util.List;

@Repository
public interface JogadorRepository extends CrudRepository<Jogador, Integer> {

    @Query("from Jogador j where j.usuario.id = :userId")
    public List<Jogador> obterLista(Integer userId);

}
