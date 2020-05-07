package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.RecensioneDTO;
import it.contrader.model.Recensione;;

public class RecensioneConverter implements Converter<Recensione, RecensioneDTO> {

	@Override
	public RecensioneDTO toDTO(Recensione recensione) {
		RecensioneDTO recensioneDTO = new RecensioneDTO(recensione.getId_recensione(), recensione.getVoto(),
				recensione.getId_ordinazione(), recensione.getTesto());
		return recensioneDTO;
	}

	@Override
	public Recensione toEntity(RecensioneDTO recensioneDTO) {
		Recensione user = new Recensione(recensioneDTO.getId_recensione(), recensioneDTO.getVoto(),
				recensioneDTO.getId_ordinazione(), recensioneDTO.getTesto());
		return user;
	}

	@Override
	public List<RecensioneDTO> toDTOList(List<Recensione> recensioneList) {
		// Crea una lista vuota.
		List<RecensioneDTO> recensioneDTOList = new ArrayList<RecensioneDTO>();

		for (Recensione recensione : recensioneList) {

			recensioneDTOList.add(toDTO(recensione));
		}
		return recensioneDTOList;
	}

}
