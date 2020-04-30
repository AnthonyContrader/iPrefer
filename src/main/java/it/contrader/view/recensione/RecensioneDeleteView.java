package it.contrader.view.recensione;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class RecensioneDeleteView extends AbstractView{

	private Request request;

	private int id_recensione;
	private final String mode = "DELETE";

	public RecensioneDeleteView() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode DELETE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione recensione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Recensione", null);
		}
	}

	/**
	 * Chiede all'utente di inserire l'id della recensione da cancellare
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci id della recensione da CANCELLARE:");
			id_recensione = Integer.parseInt(getInput());

	}

	/**
	 * impacchetta la request con l'id della recensione da cancellare
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id_recensione", id_recensione);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Recensione", "doControl", request);
	}

}
