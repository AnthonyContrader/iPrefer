package it.contrader.view.bevanda;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class BevandaInsertView extends AbstractView{
	
	private Request request;
	private String nome_bevanda;
	private float costo_bevanda;
	private boolean alcolico;
	private String descrizione;
	private final String mode = "INSERT";

	public BevandaInsertView() {
	}
	
	/**
	 * Se la request non è nulla mostra l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Bevanda", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi della bevanda da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci il nome della bevanda:");
			nome_bevanda = getInput();
			System.out.println("Inserisci il costo della bevanda:");
			costo_bevanda = Float.parseFloat(getInput());
			System.out.println("Inserisci se è alcolico:");
			alcolico = Boolean.parseBoolean(getInput());
			System.out.println("Inserisci descrizione:");
			descrizione =getInput();
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("nome_bevanda", nome_bevanda);
		request.put("costo_bevanda", costo_bevanda);
		request.put("alcolico", alcolico);
		request.put("descrizione", descrizione);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Bevanda", "doControl", request);
	}
}

