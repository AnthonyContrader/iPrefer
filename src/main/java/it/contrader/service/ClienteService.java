package it.contrader.service;

import java.util.List;


import it.contrader.converter.ClienteConverter;
import it.contrader.dao.ClienteDAO;
import it.contrader.dto.ClienteDTO;
import it.contrader.dto.UserDTO;

public class ClienteService {
	private ClienteDAO clienteDAO;
	private ClienteConverter clienteConverter;
	
	public ClienteService() {
		this.clienteDAO = new ClienteDAO();
		this.clienteConverter= new ClienteConverter();
	}
	
	public List<ClienteDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return clienteConverter.toDTOList(clienteDAO.getAll());
	}
	
	public ClienteDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return clienteConverter.toDTO(clienteDAO.read(id));
	}
	
	public boolean insert(ClienteDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return clienteDAO.insert(clienteConverter.toEntity(dto));
	}
	
	public boolean update(ClienteDTO dto) {
		// Converte un userDTO in entità e lo passa allo userDAO per la modifica
		return clienteDAO.update(clienteConverter.toEntity(dto));
	}
	
	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return clienteDAO.delete(id);
	}
	
	
}
