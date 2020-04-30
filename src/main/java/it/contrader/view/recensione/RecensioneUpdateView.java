package it.contrader.view.recensione;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class RecensioneUpdateView extends AbstractView{
	private Request request;
	
	private int id_recensione;
	private int voto;
	private int id_ordinazione;
	private String testo;
	private final String mode = "UPDATE";

	public RecensioneUpdateView() {

	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica recensione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Recensione", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi della recensione da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id della recensione DA MODIFICARE:");
			id_recensione = Integer.parseInt(getInput());
			System.out.println("Inserisci voto della recensione DA MODIFICARE:");
			voto = Integer.parseInt(getInput());
			System.out.println("Inserisci l'id dell'ordinazione DA MODIFICARE:");
			id_ordinazione = Integer.parseInt(getInput());
			System.out.println("Inserisci il testo della recensione DA MODIFICARE:");
			testo = getInput();
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id_recensione", id_recensione);
		request.put("voto", voto);
		request.put("id_ordinazione", id_ordinazione);
		request.put("testo", testo);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Recensione", "doControl", request);
	}

}
