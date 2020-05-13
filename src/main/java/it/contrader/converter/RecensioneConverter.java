package it.contrader.converter;

import org.springframework.stereotype.Component;
import it.contrader.dto.RecensioneDTO;
import it.contrader.model.Recensione;

@Component
public class RecensioneConverter extends AbstractConverter<Recensione, RecensioneDTO> {

	@Override
	public Recensione toEntity(RecensioneDTO recensioneDTO) {
		Recensione recensione = null;
		if (recensioneDTO != null) {
			recensione = new Recensione(recensioneDTO.getId(), recensioneDTO.getVoto(),
					recensioneDTO.getTesto(), recensioneDTO.getPrenotazione()); // boh
		}
		return recensione;
	}

	@Override
	public RecensioneDTO toDTO(Recensione recensione) {
		RecensioneDTO recensioneDTO = null;
		if (recensione != null) {
			recensioneDTO = new RecensioneDTO(recensione.getId(), recensione.getVoto(),
					recensione.getTesto(), recensione.getPrenotazione()); // boh

		}
		return recensioneDTO;
	}

}
