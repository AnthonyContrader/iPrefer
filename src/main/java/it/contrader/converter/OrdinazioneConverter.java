package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.OrdinazioneDTO;
import it.contrader.model.Ordinazione;

public class OrdinazioneConverter implements Converter<Ordinazione, OrdinazioneDTO>{
	
	@Override
	public OrdinazioneDTO toDTO(Ordinazione ordinazione) {
		OrdinazioneDTO ordinazioneDTO=new OrdinazioneDTO(ordinazione.GetId_Ordinazione(),ordinazione.GetId_Piatto(),ordinazione.GetId_Bevanda(),ordinazione.GetId_Cliente(),ordinazione.GetData_ora(),ordinazione.GetCosto_tot());
		return ordinazioneDTO;
	}
	
	@Override
	public Ordinazione toEntity(OrdinazioneDTO ordinazioneDTO) {
		Ordinazione ordinazione=new Ordinazione(ordinazioneDTO.GetId_Ordinazione(),ordinazioneDTO.GetId_Piatto(),ordinazioneDTO.GetId_Bevanda(),ordinazioneDTO.GetId_Cliente(),ordinazioneDTO.GetData_ora(),ordinazioneDTO.GetCosto_tot());
		return ordinazione;
	}

	@Override
	public List<OrdinazioneDTO> toDTOList(List<Ordinazione> ordinazioneList){
		List<OrdinazioneDTO> ordinazioneDTOList = new ArrayList<OrdinazioneDTO>();
		for (Ordinazione ordinazione : ordinazioneList) {
			ordinazioneDTOList.add(toDTO(ordinazione));
		}
		return ordinazioneDTOList;
	}
}
