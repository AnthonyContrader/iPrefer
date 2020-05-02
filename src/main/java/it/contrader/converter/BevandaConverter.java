package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.BevandaDTO;
import it.contrader.model.Bevanda;
/**
 * 
 * @author simone
 *
 */
public class BevandaConverter {

	/**
	 * Crea un oggetto di tipo BevandaDTO e lo riempe con i  campi del parametro bevanda di tipo Bevanda.
	 */
	public BevandaDTO toDTO(Bevanda bevanda) {
		BevandaDTO bevandaDTO = new BevandaDTO(bevanda.getId_Bevanda(),bevanda.getNome_Bevanda(), bevanda.getCosto_Bevanda(), bevanda.getAlcolico(), bevanda.getDescrizione());
		return bevandaDTO;
	}
	
	/**
	 * Crea un oggetto di tipo Bevanda e lo riempe con i campi del parametro bevanda di BevandaDTO.
	 */
	public Bevanda toEntity(BevandaDTO bevandaDTO) {
	Bevanda bevanda = new Bevanda (bevandaDTO.getId_Bevanda(), bevandaDTO.getNome_Bevanda(), bevandaDTO.getCosto_Bevanda(), bevandaDTO.getAlcolico(), bevandaDTO.getDescrizione());
	return bevanda;
	}
	public List<BevandaDTO> toDTOList(List<Bevanda> bevandaLIst) {
		// crea una lista vuota
		List<BevandaDTO> bevandaDTOList = new ArrayList<BevandaDTO>();
		
		// cicla tutti gli elementi della lista e li converte uno alla volta
		for (Bevanda bevanda: bevandaLIst) {
			//Utilizza il metodo toDTO per convertire ogni elemento della lista e lo aggiunge alla lista 
			bevandaDTOList.add(toDTO(bevanda));
		}
		return bevandaDTOList;
	}
}
