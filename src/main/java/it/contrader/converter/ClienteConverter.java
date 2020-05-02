package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ClienteDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Cliente;
import it.contrader.model.User;

public class ClienteConverter {
	
	public ClienteDTO toDTO(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO(cliente.getIdCliente(), cliente.getNomeCliente(), cliente.getCognomeCliente(), cliente.getIntolleranza(), cliente.getTelefono(), cliente.getIntollerante());
		return clienteDTO;
	}
	
	public Cliente toEntity(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente(clienteDTO.getIdCliente(), clienteDTO.getNomeCliente(), clienteDTO.getCognomeCliente(), clienteDTO.getIntolleranza(), clienteDTO.getTelefono(), clienteDTO.getIntollerante());
		return cliente;
	}
	
	public List<ClienteDTO> toDTOList(List<Cliente> clienteList) {
		//Crea una lista vuota.
		List<ClienteDTO> clienteDTOList = new ArrayList<ClienteDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Cliente cliente : clienteList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			clienteDTOList.add(toDTO(cliente));
		}
		return clienteDTOList;
	}
}
