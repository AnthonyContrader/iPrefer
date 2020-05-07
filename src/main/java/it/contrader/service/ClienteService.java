package it.contrader.service;

import it.contrader.model.Cliente;
import it.contrader.dto.ClienteDTO;
import it.contrader.dao.ClienteDAO;
import it.contrader.converter.ClienteConverter;

public class ClienteService extends AbstractService<Cliente, ClienteDTO>{
	
	public ClienteService() {
		this.dao = new ClienteDAO();
		this.converter = new ClienteConverter();
	}
}
