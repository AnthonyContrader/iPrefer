package it.contrader.view.prenotazione;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

	//@author Samuel

public class PrenotazioneInsertView extends AbstractView{
	private Request request;

	private String data_ora;
	private int tavolo;
	private int id_cliente;
	private final String mode = "INSERT";

	public PrenotazioneInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Prenotazione", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci data/ora della prenotazione:");
			data_ora = getInput();
			System.out.println("Inserisci tavolo della prenotazione:");
			tavolo = Integer.parseInt(getInput());
			System.out.println("Inserisci id del cliente:");
			id_cliente = Integer.parseInt(getInput());
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("data_ora", data_ora);
		request.put("tavolo", tavolo);
		request.put("id_cliente", id_cliente);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Prenotazione", "doControl", request);
	}


}
