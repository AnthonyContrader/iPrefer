package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PrenotazioneDTO;
import it.contrader.model.Prenotazione;


public class PrenotazioneConverter implements Converter<Prenotazione, PrenotazioneDTO> {
	
	/**
	 * Crea un oggetto di tipo PrenotazoneDTO e lo riempie con i campi del parametro prenotazione di tipo Prenotazione.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	
	@Override
	public PrenotazioneDTO toDTO(Prenotazione prenotazione) {
		PrenotazioneDTO prenotazioneDTO = new PrenotazioneDTO(prenotazione.getId_prenotazione(), prenotazione.getData_ora(), prenotazione.getTavolo(), prenotazione.getId_cliente());
		return prenotazioneDTO;
	}
	
	/**
	 * Crea un oggetto di tipo Prenotazione e lo riempie con i campi del parametro prenotazione di tipo PrenotazioneDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	
	@Override
	public Prenotazione toEntity(PrenotazioneDTO prenotazioneDTO) {
		Prenotazione prenotazione = new Prenotazione(prenotazioneDTO.getId_prenotazione(), prenotazioneDTO.getData_ora(), prenotazioneDTO.getTavolo(), prenotazioneDTO.getId_cliente());
		return prenotazione;
	}
	
	/**
	 * Metodo per convertire le liste di Prenotazione.
	 */
	
	@Override
	public List<PrenotazioneDTO> toDTOList(List<Prenotazione> prenotazioneList) {
		//Crea lista vuota
		List<PrenotazioneDTO> prenotazioneDTOList = new ArrayList<PrenotazioneDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for (Prenotazione prenotazione : prenotazioneList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			prenotazioneDTOList.add(toDTO(prenotazione));
		}
		return prenotazioneDTOList;
	}
	
}
