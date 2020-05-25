package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.PrenotazioneConverter;
import it.contrader.dao.PrenotazioneRepository;
import it.contrader.dto.PrenotazioneDTO;
import it.contrader.model.Prenotazione;

@Service
public class PrenotazioneService extends AbstractService<Prenotazione, PrenotazioneDTO>{
	
	@Autowired
	private PrenotazioneConverter converter;
	@Autowired
	private PrenotazioneRepository repository;
	
	public PrenotazioneDTO findById(long id) {
		return converter.toDTO(repository.findById(id));
	}

}
