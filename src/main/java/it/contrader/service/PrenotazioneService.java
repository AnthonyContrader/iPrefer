package it.contrader.service;

import it.contrader.converter.PrenotazioneConverter;
import it.contrader.dao.PrenotazioneDAO;
import it.contrader.dto.PrenotazioneDTO;
import it.contrader.model.Prenotazione;


public class PrenotazioneService extends AbstractService<Prenotazione, PrenotazioneDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public PrenotazioneService() {
		this.dao = new PrenotazioneDAO();
		this.converter = new PrenotazioneConverter();
	}

}
