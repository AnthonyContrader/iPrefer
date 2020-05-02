package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.PrenotazioneDTO;
import it.contrader.main.MainDispatcher;

	//@author Samuel

public class PrenotazioneView extends AbstractView {
	
	private Request request;
	private String choice;
	
	public PrenotazioneView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione prenotazioni ----------------\n");
			System.out.println("ID_PRENOTAZIONE\t\tDATA/ORA\t\t\tTAVOLO\t\tID_CLIENTE");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<PrenotazioneDTO> prenotazioni = (List<PrenotazioneDTO>) request.get("prenotazioni");
			for (PrenotazioneDTO p: prenotazioni)
				System.out.println(p);
			System.out.println();
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();
	
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Prenotazione", "doControl", this.request);
	}
	
}
