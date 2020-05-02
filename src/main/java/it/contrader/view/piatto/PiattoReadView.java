package it.contrader.view.piatto;

import it.contrader.controller.Request;

import it.contrader.dto.PiattoDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * @author Ambrogio S.
 *
 *Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class PiattoReadView extends AbstractView {

	private int id_piatto;
	private Request request;
	private final String mode = "READ";

	public PiattoReadView() {
	}

	/**
	 * Se la request è null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo è vuoto.
	 * 
	 * Altrimenti se arriva con un piatto nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra il piatto. In questo caso torna alla PiattoView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			PiattoDTO piatto = (PiattoDTO)request.get("piatto");
			System.out.println(piatto);
			MainDispatcher.getInstance().callView("Piatto", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id del piatto da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del piatto da leggere:");
		id_piatto = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id del piatto da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id_piatto", id_piatto);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Piatto", "doControl", request);
	}

}
