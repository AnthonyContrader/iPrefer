package it.contrader.converter;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import it.contrader.dto.PrenotazioneDTO;

import it.contrader.model.Prenotazione;

@Component
public class PrenotazioneConverter extends AbstractConverter<Prenotazione, PrenotazioneDTO> {
	
	@Autowired
	private ClienteConverter clienteConverter;
	
	@Override
	public Prenotazione toEntity(PrenotazioneDTO prenotazioneDTO ) {
		Prenotazione prenotazione = null;
		if (prenotazioneDTO != null) {
			prenotazione = new Prenotazione();
			
			prenotazione.setId(prenotazioneDTO.getId());
			prenotazione.setData_ora(prenotazioneDTO.getData_ora());
			prenotazione.setTavolo(prenotazioneDTO.getTavolo());
			
			if(prenotazioneDTO.getClienteDTO()!= null) {
				prenotazione.setCliente(clienteConverter.toEntity(prenotazioneDTO.getClienteDTO()));
			}
		}
		return prenotazione;
	}
	
	@Override
	public PrenotazioneDTO toDTO(Prenotazione prenotazione) {
		PrenotazioneDTO prenotazioneDTO = null;
		if (prenotazione != null) {
			prenotazioneDTO= new PrenotazioneDTO();
			
			prenotazioneDTO.setId(prenotazione.getId());
			prenotazioneDTO.setData_ora(prenotazione.getData_ora());
			prenotazioneDTO.setTavolo(prenotazione.getTavolo());
			
			if(prenotazione.getCliente()!= null) {
				prenotazioneDTO.setClienteDTO(clienteConverter.toDTO(prenotazione.getCliente()));
			}
		}
		return prenotazioneDTO;
	}

}
