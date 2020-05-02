package it.contrader.view.prenotazione;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

//@author Samuel

public class PrenotazioneUpdateView extends AbstractView {
	private Request request;

	private int id_prenotazione;
	private String data_ora;
	private int tavolo;
	private int id_cliente;
	private final String mode = "UPDATE";

	public PrenotazioneUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Prenotazione", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id della prenotazione da modificare:");
			id_prenotazione = Integer.parseInt(getInput());
			System.out.println("Inserisci la nuova data e ora della prenotazione");
			data_ora = getInput();
			System.out.println("Inserisci il nuovo il numero del tavolo:");
			tavolo = Integer.parseInt(getInput());
			System.out.println("Inserisci il nuovo l'ID del cliente:");
			id_cliente = Integer.parseInt(getInput());
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id_prenotazione", id_prenotazione);
		request.put("data_ora", data_ora);
		request.put("tavolo", tavolo);
		request.put("id_cliente", id_cliente);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Prenotazione", "doControl", request);
	}

}
