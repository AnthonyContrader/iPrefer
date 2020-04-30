package it.contrader.view.recensione;

import it.contrader.controller.Request;
import it.contrader.dto.RecensioneDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class RecensioneReadView extends AbstractView {

	private int id_recensione;
	private Request request;
	private final String mode = "READ";

	public RecensioneReadView() {

	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			RecensioneDTO recensione = (RecensioneDTO) request.get("recensione");
			System.out.println(recensione);
			MainDispatcher.getInstance().callView("Recensione", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID della recensione DA LEGGERE:");
		id_recensione = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id della recensione da leggere e la manda al
	 * controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id_recensione", id_recensione);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Recensione", "doControl", request);
	}
}
