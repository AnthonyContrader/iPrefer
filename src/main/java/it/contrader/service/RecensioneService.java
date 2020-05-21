package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.contrader.converter.RecensioneConverter;
import it.contrader.dao.RecensioneRepository;
import it.contrader.dto.RecensioneDTO;
import it.contrader.model.Recensione;

@Service
public class RecensioneService extends AbstractService<Recensione, RecensioneDTO> {

	@Autowired
	private RecensioneConverter converter;
	@Autowired
	private RecensioneRepository repository;

	public RecensioneDTO findById(long id) {
		return converter.toDTO(repository.findById(id));
	}
}