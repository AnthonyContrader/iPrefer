package it.contrader.view.piatto;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class PiattoInsertView extends AbstractView{
	private Request request;

	private String nome_piatto;
	private String ingredienti;
	private float costo_piatto;
	private String descrizione_piatto;
	private final String mode = "INSERT";

	public PiattoInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Piatto", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci il nome del piatto:");
			nome_piatto = getInput();
			System.out.println("Inserisci gli ingredienti che compongono il piatto:");
			ingredienti = getInput();
			System.out.println("Inserisci il costo del piatto:");
			costo_piatto = Float.parseFloat(getInput());
			System.out.println("Inserisci la descrizione del piatto:");
			descrizione_piatto = getInput();
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("nome_piatto", nome_piatto);
		request.put("ingredienti", ingredienti);
		request.put("costo_piatto", costo_piatto);
		request.put("descrizione_piatto", descrizione_piatto);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Piatto", "doControl", request);
	}


}
