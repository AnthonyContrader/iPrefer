package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.BevandaConverter;
import it.contrader.dao.BevandaRepository;
import it.contrader.dto.BevandaDTO;
import it.contrader.model.Bevanda;

@Service
public class BevandaService extends AbstractService<Bevanda, BevandaDTO>{
	
	@Autowired
	private BevandaConverter converter;
	@Autowired
	private BevandaRepository repository;
	
	public BevandaDTO findById(long id) {
		return converter.toDTO(repository.findById(id));
	}
}
