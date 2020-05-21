package it.contrader.converter;

import org.springframework.stereotype.Component;


import it.contrader.dto.ClienteDTO;
import it.contrader.model.Cliente;

@Component
public class ClienteConverter extends AbstractConverter<Cliente, ClienteDTO>{

	@Override
	public ClienteDTO toDTO(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO(cliente.getId(), cliente.getNome_cliente(), cliente.getCognome_cliente(), cliente.isIntolleranza_bool(), cliente.getTelefono(), cliente.getIntollerante());
		return clienteDTO;
	}
	
	@Override
	public Cliente toEntity(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente(clienteDTO.getId(), clienteDTO.getNome_cliente(), clienteDTO.getCognome_cliente(), clienteDTO.isIntolleranza_bool(), clienteDTO.getTelefono(), clienteDTO.getIntollerante());
		return cliente;
	}
}
