package br.edu.infnet.apptimes.model.repository;

import br.edu.infnet.apptimes.model.domain.Dirigente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apptimes.model.domain.Tecnico;

import java.util.List;

@Repository
public interface TecnicoRepository extends CrudRepository<Tecnico, Integer> {

    @Query("from Tecnico t where t.usuario.id = :userId")
    public List<Tecnico> obterLista(Integer userId);

}
