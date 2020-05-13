package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.PiattoDTO;

import it.contrader.model.Piatto;

@Component
public class PiattoConverter extends AbstractConverter<Piatto, PiattoDTO> {

	@Override
	public Piatto toEntity(PiattoDTO piattoDTO) {
		Piatto piatto = null;
		if (piattoDTO != null) {
			piatto = new Piatto(piattoDTO.getId(), piattoDTO.getNome_piatto(), piattoDTO.getIngredienti(), piattoDTO.getCosto_piatto(),piattoDTO.getDescrizione_piatto());
		}
		return piatto;
	}

	@Override
	public PiattoDTO toDTO(Piatto piatto) {
		PiattoDTO piattoDTO = null;
		if (piatto != null) {
			piattoDTO = new PiattoDTO(piatto.getId(), piatto.getNome_piatto(), piatto.getIngredienti(), piatto.getCosto_piatto(), piatto.getDescrizione_piatto());

		}
		return piattoDTO;
	}
}