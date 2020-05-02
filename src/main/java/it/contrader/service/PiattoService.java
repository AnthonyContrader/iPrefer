package it.contrader.service;

import java.util.List;

import it.contrader.converter.PiattoConverter;
import it.contrader.dao.PiattoDAO;
import it.contrader.dto.PiattoDTO;


/**
 * 
 * @author Santo, Ambrogio
 *
 *Grazie all'ereditariet� mi basta specificare i tipi di questa classe ed
 *ereditare i metodi della clase AbstractService.
 */

public class PiattoService {
	
	private PiattoDAO piattoDAO;
	private PiattoConverter piattoConverter;

// Costruttore
	
public PiattoService(){
		this.piattoDAO = new PiattoDAO();
		this.piattoConverter = new PiattoConverter();
	}

//metodo che estrae tutti i DTO utilizzando la quesy di lettura del DAO. In questa applicazione un DTO � del
// tutto uguale al Model 
public List<PiattoDTO> getAll() {
	// Ottiene una lista di entit� e le restituisce convertendole in DTO
	return piattoConverter.toDTOList(piattoDAO.getAll());
}

//Query di lettura con id
public PiattoDTO read(int id_piatto) {
	// Ottiene un'entit� e la restituisce convertendola in DTO
	return piattoConverter.toDTO(piattoDAO.read(id_piatto));
}

//metodo che si occupa dell'inseriemnto nel db
public boolean insert(PiattoDTO piattoDTO) {
	// Converte un DTO in entit� e lo passa al DAO per l'inserimento
	return piattoDAO.insert(piattoConverter.toEntity(piattoDTO));
}


public boolean update(PiattoDTO piattoDTO) {
	// Converte un userDTO in entit� e lo passa allo userDAO per la modifica
	return piattoDAO.update(piattoConverter.toEntity(piattoDTO));
}


public boolean delete(int id_piatto) {
	// Questo metodo chiama direttamente il DAO
	return piattoDAO.delete(id_piatto);
}


}