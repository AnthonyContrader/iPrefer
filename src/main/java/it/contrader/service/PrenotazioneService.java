package it.contrader.service;

import java.util.List;
import it.contrader.converter.PrenotazioneConverter;
import it.contrader.dao.PrenotazioneDAO;
import it.contrader.dto.PrenotazioneDTO;

	//@author Samuel

public class PrenotazioneService {
		
	private PrenotazioneDAO prenotazioneDAO;
	private PrenotazioneConverter prenotazioneConverter;
		
	//Istanzio DAO e Converter specifici.
	public PrenotazioneService() {
		this.prenotazioneDAO = new PrenotazioneDAO();
		this.prenotazioneConverter = new PrenotazioneConverter();
	}
		
		
	public List<PrenotazioneDTO> getAll() {
		//Ottiene una lista di entità e restituisce convertendole in DTO
		return prenotazioneConverter.toDTOList(prenotazioneDAO.getAll());
	}
		
		
	public PrenotazioneDTO read(int id_prenotazione) {
		return prenotazioneConverter.toDTO(prenotazioneDAO.read(id_prenotazione));
	}
	
	
	public boolean insert(PrenotazioneDTO dto) {
		return prenotazioneDAO.insert(prenotazioneConverter.toEntity(dto));
	}
	
	
	public boolean update (PrenotazioneDTO dto ) {
		return prenotazioneDAO.update(prenotazioneConverter.toEntity(dto));
	}
	
	
	public boolean delete (int id_prenotazione) {
		return prenotazioneDAO.delete(id_prenotazione);
	}
	
	
}

