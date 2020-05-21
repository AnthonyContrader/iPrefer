package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.PiattoConverter;
import it.contrader.dao.PiattoRepository;
import it.contrader.dto.PiattoDTO;
import it.contrader.model.Piatto;

@Service
public class PiattoService extends AbstractService<Piatto, PiattoDTO> {

	@Autowired
	private PiattoConverter converter;
	@Autowired
	private PiattoRepository repository;

	public PiattoDTO findById(long id) {
		return converter.toDTO(repository.findById(id));
	}

}