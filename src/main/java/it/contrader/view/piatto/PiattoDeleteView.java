package it.contrader.view.piatto;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class PiattoDeleteView extends AbstractView {
	private Request request;

	private int id_piatto;
	private final String mode = "DELETE";

	public PiattoDeleteView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode DELETE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Piatto", null);
		}
	}

	/**
	 * Chiede all'utente di inserire l'id del piatto da cancellare
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci id del piatto da cancellare:");
			id_piatto = Integer.parseInt(getInput());

	}

	/**
	 * impacchetta la request con l'id del piatto da cancellare
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id_piatto", id_piatto);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Piatto", "doControl", request);
	}


}

