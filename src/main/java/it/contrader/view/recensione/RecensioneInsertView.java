package it.contrader.view.recensione;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class RecensioneInsertView extends AbstractView{
	
	private Request request;

	private int voto;
	private int id_ordinazione;
	private String testo;
	private final String mode = "INSERT";
	
	public  RecensioneInsertView() {
		
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento recensione andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Recensione", null);
		}
	}
	
	/**
	 * Chiede all'utente di inserire gli attributi della recensione da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci il voto della recensione DA INSERIRE:");
			voto = Integer.parseInt(getInput());
			System.out.println("Inserisci l'id dell'ordinazione DA INSERIRE:");
			id_ordinazione = Integer.parseInt(getInput());
			System.out.println("Inserisci il testo della recensione DA INSERIRE:");
			testo = getInput();
	}
	

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("voto", voto);
		request.put("id_ordinazione", id_ordinazione);
		request.put("testo", testo);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Recensione", "doControl", request);
	}

	
}
