package it.contrader.view.bevanda;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class BevandaDeleteView extends AbstractView {

	private Request request;

	private int id_bevanda;
	private final String mode = "DELETE";

	public BevandaDeleteView() {
		
	}
		/**
		 * se la request non è nulla mostra l'esito
		 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Bevanda", null);
		}
	}
	//chiede all'utente di inserire l'id dell'utente da cancellare
	
	@Override
	public void showOptions() {
		System.out.println("Inserisci id della bevanda da eliminare");
		id_bevanda = Integer.parseInt(getInput());
	}
	//impacchetta la request con l'id della bevanda da cancellare
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id_bevanda", id_bevanda);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Bevanda", "doControl", request);
	}
	
}
