package it.contrader.dao;


import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Ordinazione;

@Repository
@Transactional
public interface OrdinazioneRepository extends CrudRepository<Ordinazione, Long> {
	
Ordinazione findById(long id);
}

