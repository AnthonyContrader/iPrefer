package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Prenotazione;

@Repository
@Transactional
public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Long> {
	
	Prenotazione findByClienteId(long id);

}
