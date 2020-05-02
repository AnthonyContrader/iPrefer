package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.PiattoDTO;
import it.contrader.main.MainDispatcher;

// Autore Ambrogio S.
//Alla View Arrivano tutti oggetti di tipo DTO
//
public class PiattoView extends AbstractView {
	
	private Request request;
	private String choice;

	public PiattoView() {
		
	}
	
	/**
	 * Mostra la lista piatti
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n--------------------------- Gestione piatti -----------------------\n");
			System.out.println("id_piatto\tnome_piatto\tingredienti\tdescrizione_piatto\tcosto_piatto");
			System.out.println("-----------------------------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<PiattoDTO> piatti = (List<PiattoDTO>) request.get("piatti");
			for (PiattoDTO p: piatti)
				System.out.println(p);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi PiattoController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda al PiattoController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Piatto", "doControl", this.request);
	}



}
