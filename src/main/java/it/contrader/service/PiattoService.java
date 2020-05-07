package it.contrader.service;

import it.contrader.converter.PiattoConverter;
import it.contrader.dao.PiattoDAO;
import it.contrader.dto.PiattoDTO;
import it.contrader.model.Piatto;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class PiattoService extends AbstractService<Piatto, PiattoDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public PiattoService(){
		this.dao = new PiattoDAO();
		this.converter = new PiattoConverter();
	}
	

}