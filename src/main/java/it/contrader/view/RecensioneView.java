package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.RecensioneDTO;
import it.contrader.main.MainDispatcher;

public class RecensioneView extends AbstractView {

	private Request request;
	private String choice;

	public RecensioneView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if(request != null) {
			System.out.println("\n ----------------- Gestione RECENSIONE ------------ \n");
			System.out.println("ID_REC \t VOTO \t ID_ORDIN \t TESTO");
			System.out.println("------------------------------------------- \n");
			
			@SuppressWarnings("unchecked")
			List<RecensioneDTO> recensioni = (List<RecensioneDTO>) request.get("recensioni");
			for(RecensioneDTO r :recensioni) 
				System.out.println(r);
			System.out.println();
		}
	}
	
	/*Chiede all'utente una lettera per la scelta*/
	
	@Override
	public void showOptions() {
		System.out.println("    Scegli l'operazione da eseguire :   ");
		System.out.println("[L]eggi_Recensione [I]nserisci_Recensione [M]odifica_Recensione [C]ancella_Recensione [B]ack [E]sci");
		this.choice = getInput();
	}
	
	/*Impacchetto la richiesta e la mando alla RecensioneController*/
	
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Recensione", "doControl", this.request);
		
	}
	
}
