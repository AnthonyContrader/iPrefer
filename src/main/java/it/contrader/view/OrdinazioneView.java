package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.OrdinazioneDTO;
import it.contrader.main.MainDispatcher;

public class OrdinazioneView extends AbstractView{
	
	private Request request;
	private String choice;

	public OrdinazioneView() {
		
	}
	public void showResults(Request request) {
		
		if (request != null) {
			System.out.println("\n------------------- Gestione ordinazione ----------------\n");
			System.out.println("Id_ordinazione\tId_piatto\tId_bevanda\tId_cliente\tData_ora\tcosto_tot");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<OrdinazioneDTO> ordinazioni = (List<OrdinazioneDTO>) request.get("ordinazioni");
			for (OrdinazioneDTO o: ordinazioni)
				System.out.println(o);
			System.out.println();
		}
		
	}
	
	
	@Override
	public void showOptions() {
		
		System.out.println("         Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();
}
	
	public void submit() {
		
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Ordinazione", "doControl", this.request);
	}

	
}
