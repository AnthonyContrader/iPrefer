package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.BevandaDTO;
import it.contrader.model.Bevanda;
/**
 * 
 * @author simone
 *
 *
 */
public class BevandaConverter implements Converter<Bevanda,BevandaDTO>{
	//creo un oggetto di tipo bevandaDTO e lo riempo con i campi del paramentro Bevanda di tipo bevanda
	@Override
	public BevandaDTO toDTO(Bevanda  bevanda) {
		BevandaDTO bevandaDTO = new BevandaDTO (bevanda.getId_Bevanda(), bevanda.getNome_Bevanda(), bevanda.getCosto_Bevanda(), bevanda.getAlcolico(),bevanda.getDescrizione());
		return bevandaDTO;
	}
	@Override
	public Bevanda toEntity(BevandaDTO bevandaDTO) {
		Bevanda bevanda = new Bevanda(bevandaDTO.getId_Bevanda(), bevandaDTO.getNome_Bevanda(), bevandaDTO.getCosto_Bevanda(), bevandaDTO.getAlcolico(), bevandaDTO.getDescrizione());
		return bevanda;		
	}
	/**
	 * metodo per convertire le liste di bevande
	 */
	@Override
	public List<BevandaDTO> toDTOList(List<Bevanda> bevandaList) {
		//crea una lista vuota
		List<BevandaDTO> bevandaDTOList = new ArrayList<BevandaDTO>();
		//cicla tutti gli elementi della lista e li converte uno ad uno
		for(Bevanda bevanda: bevandaList) {
			// utilizzo il metodo toDTO per  convertire ogni elemento della lista e lo aggiunge alla lista DTO
			bevandaDTOList.add(toDTO(bevanda));
		}
		return bevandaDTOList;
	}
}
