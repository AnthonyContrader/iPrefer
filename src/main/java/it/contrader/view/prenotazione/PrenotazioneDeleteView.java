package it.contrader.view.prenotazione;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

	//@author Samuel

public class PrenotazioneDeleteView extends AbstractView {
	private Request request;

	private int id_prenotazione;
	private final String mode = "DELETE";

	public PrenotazioneDeleteView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode DELETE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Prenotazione", null);
		}
	}

	/**
	 * Chiede all'utente di inserire l'id della prenotazione da cancellare
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci id della prenotazione da cancellare:");
			id_prenotazione = Integer.parseInt(getInput());

	}

	/**
	 * impacchetta la request con l'id della prenotazione da cancellare
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id_prenotazione", id_prenotazione);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Prenotazione", "doControl", request);
	}


}
