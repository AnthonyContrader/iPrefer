package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Bevanda;

@Repository
@Transactional
public interface BevandaRepository extends CrudRepository <Bevanda, Long> {
	
	Bevanda findById(long id);
}
