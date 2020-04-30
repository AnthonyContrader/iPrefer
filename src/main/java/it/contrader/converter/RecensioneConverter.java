package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.RecensioneDTO;
import it.contrader.model.Recensione;

public class RecensioneConverter {

	public RecensioneDTO toDTO(Recensione recensione) {
		RecensioneDTO recensioneDTO = new RecensioneDTO(recensione.getId_recensione(), recensione.getVoto(),recensione.getId_ordinazione(),
				recensione.getTesto());
		return recensioneDTO;
	}

	public Recensione toEntity(RecensioneDTO recensioneDTO) {
		Recensione recensione = new Recensione(recensioneDTO.getId_recensione(), recensioneDTO.getVoto(),recensioneDTO.getId_ordinazione(),
				recensioneDTO.getTesto());
		return recensione;
	}

	public List<RecensioneDTO> toDTOList(List<Recensione> recensioneList) {

		List<RecensioneDTO> recensioneDTOList = new ArrayList<RecensioneDTO>();

		for (Recensione recensione : recensioneList) {
			recensioneDTOList.add(toDTO(recensione));
		}
		return recensioneDTOList;
	}
}
