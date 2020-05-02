package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.OrdinazioneDTO;
import it.contrader.model.Ordinazione;

public class OrdinazioneConverter {

	public OrdinazioneDTO toDTO(Ordinazione ordinazione) {
		OrdinazioneDTO ordinazioneDTO=new OrdinazioneDTO(ordinazione.getId_ordinazione(),ordinazione.getId_piatto(),ordinazione.getId_bevanda(),ordinazione.getId_cliente(),ordinazione.getData_ora(),ordinazione.getCosto_tot());
		return ordinazioneDTO;
	}
	
	public Ordinazione toEntity(OrdinazioneDTO ordinazioneDTO) {
		Ordinazione ordinazione=new Ordinazione(ordinazioneDTO.getId_ordinazione(),ordinazioneDTO.getId_piatto(),ordinazioneDTO.getId_bevanda(),ordinazioneDTO.getId_cliente(),ordinazioneDTO.getData_ora(),ordinazioneDTO.getCosto_tot());
		return ordinazione;
	}
	
	public List<OrdinazioneDTO> toDTOList(List <Ordinazione> ordinazioneList){
		List<OrdinazioneDTO> ordinazioneDTOList = new ArrayList<OrdinazioneDTO>();
		
		for(Ordinazione ordinazione : ordinazioneList) {
			ordinazioneDTOList.add(toDTO(ordinazione));
		}
		return ordinazioneDTOList;
	}
		
}
