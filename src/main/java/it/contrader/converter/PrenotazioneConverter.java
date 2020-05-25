package it.contrader.converter;

import org.springframework.stereotype.Component;
//import org.springframework.beans.factory.annotation.Autowired;
import it.contrader.dto.PrenotazioneDTO;

import it.contrader.model.Prenotazione;

@Component
public class PrenotazioneConverter extends AbstractConverter<Prenotazione, PrenotazioneDTO> {
	
	//@Autowired
	//private ClienteConverter clienteConverter;
	
	@Override
	public Prenotazione toEntity(PrenotazioneDTO prenotazioneDTO ) {
		Prenotazione prenotazione = null;
		if (prenotazioneDTO != null) {
			prenotazione = new Prenotazione(prenotazioneDTO.getId(), prenotazioneDTO.getData_ora(), prenotazioneDTO.getTavolo(), 
					prenotazioneDTO.getCliente());
		}
		return prenotazione;
	}
	
	@Override
	public PrenotazioneDTO toDTO(Prenotazione prenotazione) {
		PrenotazioneDTO prenotazioneDTO = null;
		if (prenotazione != null) {
			prenotazioneDTO = new PrenotazioneDTO(prenotazione.getId(), prenotazione.getData_ora(), prenotazione.getTavolo(), 
					prenotazione.getCliente());
		}
		return prenotazioneDTO;
	}

}
