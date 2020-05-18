package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.OrdinazioneDTO;
import it.contrader.model.Ordinazione;

@Component
public class OrdinazioneConverter extends AbstractConverter<Ordinazione, OrdinazioneDTO>{

	@Override
	public Ordinazione toEntity(OrdinazioneDTO ordinazioneDTO) {
		Ordinazione ordinazione = null;
		if (ordinazioneDTO != null) {
			ordinazione = new Ordinazione(ordinazioneDTO.getId(),ordinazioneDTO.getPiatto(),ordinazioneDTO.getBevanda(),ordinazioneDTO.getPrenotazione(),ordinazioneDTO.getCosto_tot(),ordinazioneDTO.getData_ora());
			
		}
		
		return ordinazione;
	}
	
	
	@Override
	public OrdinazioneDTO toDTO(Ordinazione ordinazione) {
		OrdinazioneDTO ordinazioneDTO = null;
		if(ordinazione != null) {
			ordinazioneDTO = new OrdinazioneDTO(ordinazione.getId(),ordinazione.getCosto_tot(),ordinazione.getData_ora(),ordinazione.getPiatto(),ordinazione.getBevanda(),ordinazione.getPrenotazione());
		}
		return ordinazioneDTO;
	}
	
}
