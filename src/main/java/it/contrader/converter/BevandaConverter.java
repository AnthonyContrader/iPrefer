package it.contrader.converter;

import org.springframework.stereotype.Component;
import it.contrader.dto.BevandaDTO;
import it.contrader.model.Bevanda;

@Component
public class BevandaConverter extends AbstractConverter<Bevanda, BevandaDTO>{
	
	@Override
	public Bevanda toEntity(BevandaDTO bevandaDTO) {
		Bevanda bevanda = null ;
		if(bevandaDTO != null) {
			bevanda = new Bevanda(bevandaDTO.getId(),bevandaDTO.getNome_bevanda(), bevandaDTO.getCosto_bevanda(), bevandaDTO.getAlcolico(), bevandaDTO.getDescrizione());
		}
		return bevanda;
	}
	
	@Override
	public BevandaDTO toDTO(Bevanda bevanda) {
		BevandaDTO bevandaDTO = null;
		if(bevanda!= null) {
			bevandaDTO = new BevandaDTO(bevanda.getId(), bevanda.getNome_bevanda(), bevanda.getCosto_bevanda(), bevanda.getAlcolico(), bevanda.getDescrizione());
		}
		return bevandaDTO;
	}
}
