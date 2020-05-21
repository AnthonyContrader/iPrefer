package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.ClienteConverter;
import it.contrader.dao.ClienteRepository;
import it.contrader.dto.ClienteDTO;
import it.contrader.model.Cliente;

@Service
public class ClienteService extends AbstractService<Cliente, ClienteDTO> {
	
	@Autowired
	private ClienteConverter converter;
	@Autowired
	private ClienteRepository repository;
	
	public ClienteDTO findById(long id) {
		return converter.toDTO(repository.findById(id));
	}
}
