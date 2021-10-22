package br.edu.infnet.apptimes.model.repository;

import br.edu.infnet.apptimes.model.domain.Tecnico;
import br.edu.infnet.apptimes.model.domain.Time;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeRepository extends CrudRepository<Time, Integer> {

    @Query("from Time t where t.usuario.id = :userId")
    public List<Time> obterLista(Integer userId);

}
