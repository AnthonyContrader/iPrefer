package it.contrader.view.prenotazione;

import it.contrader.controller.Request;

import it.contrader.dto.PrenotazioneDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * @author Samuel
 *
 *Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class PrenotazioneReadView extends AbstractView {

	private int id_prenotazione;
	private Request request;
	private final String mode = "READ";

	public PrenotazioneReadView() {
	}

	/**
	 * Se la request è null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo è vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			PrenotazioneDTO prenotazione = (PrenotazioneDTO) request.get("prenotazione");
			System.out.println(prenotazione);
			MainDispatcher.getInstance().callView("Prenotazione", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id della prenotazione da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID della prenotazione da visualizzare:");
		id_prenotazione = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id_prenotazione", id_prenotazione);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Prenotazione", "doControl", request);
	}

}
