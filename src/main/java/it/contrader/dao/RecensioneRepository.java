package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Recensione;

@Repository
@Transactional
public interface RecensioneRepository extends CrudRepository<Recensione, Long> {

	Recensione findById(long id);
	
}