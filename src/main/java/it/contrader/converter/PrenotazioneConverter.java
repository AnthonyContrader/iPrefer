package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PrenotazioneDTO;
import it.contrader.model.Prenotazione;

	//@author Samuel

public class PrenotazioneConverter {
	
	public PrenotazioneDTO toDTO(Prenotazione prenotazione) {
		PrenotazioneDTO prenotazioneDTO = new PrenotazioneDTO(prenotazione.getId_prenotazione(), prenotazione.getData_ora(), prenotazione.getTavolo(), prenotazione.getId_cliente());
		return prenotazioneDTO;
	}
	
	
	public Prenotazione toEntity(PrenotazioneDTO prenotazioneDTO) {
		Prenotazione prenotazione = new Prenotazione(prenotazioneDTO.getId_prenotazione(), prenotazioneDTO.getData_ora(), prenotazioneDTO.getTavolo(), prenotazioneDTO.getId_cliente());
		return prenotazione;
	}
	
	
	public List <PrenotazioneDTO> toDTOList (List<Prenotazione> prenotazioneList) {
		List <PrenotazioneDTO> prenotazioneDTOList = new ArrayList<PrenotazioneDTO>();
		
		for (Prenotazione prenotazione : prenotazioneList) {
			prenotazioneDTOList.add(toDTO(prenotazione));
		}
		return prenotazioneDTOList;
	}
	
}
