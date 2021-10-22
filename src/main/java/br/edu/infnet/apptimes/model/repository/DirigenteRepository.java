package br.edu.infnet.apptimes.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apptimes.model.domain.Dirigente;

import java.util.List;

@Repository
public interface DirigenteRepository extends CrudRepository<Dirigente, Integer> {

    @Query("from Dirigente d where d.usuario.id = :userId")
    public List<Dirigente> obterLista(Integer userId);
}
