package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.OrdinazioneConverter;
import it.contrader.dao.OrdinazioneRepository;
import it.contrader.dto.OrdinazioneDTO;
import it.contrader.model.Ordinazione;

@Service
public class OrdinazioneService extends AbstractService<Ordinazione, OrdinazioneDTO> {

	@Autowired
	private OrdinazioneConverter converter;
	@Autowired
	private OrdinazioneRepository repository;
	
	public OrdinazioneDTO findById_ordinazione(long id){
		return converter.toDTO(repository.findById(id));
	}
	
	
}
