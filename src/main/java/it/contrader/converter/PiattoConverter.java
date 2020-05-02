package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PiattoDTO;
import it.contrader.model.Piatto;


// @author Ambrogio S.

public class PiattoConverter {
	
	
	/**
	 * Metodo che restituisce un oggetto di tipo piattoDTO prendendo in ingresso un oggetto di tipo piatto.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public PiattoDTO toDTO(Piatto piatto) {
		PiattoDTO piattoDTO = new PiattoDTO(piatto.getIdPiatto(), piatto.getNomePiatto(), piatto.getIngredienti(), piatto.getCostoPiatto(), piatto.getDescrizionePiatto());
		return piattoDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public Piatto toEntity(PiattoDTO piattoDTO) {
		Piatto piatto = new Piatto(piattoDTO.getIdPiatto(), piattoDTO.getNomePiatto(), piattoDTO.getIngredienti(), piattoDTO.getCostoPiatto(),piattoDTO.getDescrizionePiatto());
		return piatto;
	}
	
	/**
	 * Metodo per convertire liste di piatto in liste di DTO.
	 */
	public List<PiattoDTO> toDTOList(List<Piatto> piattoList) {
		//Crea una lista vuota di tipo PiattoDTO.
		List<PiattoDTO> piattoDTOList = new ArrayList<PiattoDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Piatto piatto : piattoList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			piattoDTOList.add(toDTO(piatto));
		}
		return piattoDTOList;
	}


}
