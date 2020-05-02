package it.contrader.view.ordinazione;

import it.contrader.controller.Request;
import it.contrader.dto.OrdinazioneDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class OrdinazioneReadView extends AbstractView {

	private int id_ordinazione;
	private Request request;
	private final String mode = "READ";

	public OrdinazioneReadView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			OrdinazioneDTO ordinazione = (OrdinazioneDTO) request.get("ordinazione");
			System.out.println(ordinazione);
			MainDispatcher.getInstance().callView("Ordinazione", null);
		}
	}

	
	public void showOptions() {
		System.out.println("Inserisci l'ID dell'ordinazione:");
		id_ordinazione = Integer.parseInt(getInput());
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id_ordinazione", id_ordinazione);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Ordinazione", "doControl", request);
	}
}
