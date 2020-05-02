package it.contrader.view.bevanda;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class BevandaUpdateView extends AbstractView {
	
	private Request request;
	private int id_bevanda;
	private String nome_bevanda;
	private float costo_bevanda;
	private boolean alcolico;
	private String descrizione;
	private final String mode = "UPDATE";
	
	public BevandaUpdateView() {
		
	}
	// se la  request non è nulla mostra l'esito dell'operazione 
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Bevanda", null);
		}
	}
	@Override
	public void showOptions () {
		try {
			System.out.println("Inserire id della bevanda da modificare");
			id_bevanda = Integer.parseInt(getInput());
			System.out.println("Inserire il nome della bevanda da modificare");
			nome_bevanda = getInput();
			System.out.println("Inserire costo della bevanda da modificare");
			costo_bevanda = Float.parseFloat(getInput());
			System.out.println("Inserire se è alcolico da modificare");
			alcolico = Boolean.parseBoolean(getInput());
			System.out.println("Inserire descrizione da modificare");
			descrizione = getInput();
		}catch (Exception e) {
			
		}
	}
	
	//impacchetta la request con i dati inseriti nel metodo showOption()
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id_bevanda", id_bevanda);
		request.put("nome_bevanda", nome_bevanda);
		request.put("costo_bevanda", costo_bevanda);
		request.put("alcolico", alcolico);
		request.put("descrizione", descrizione);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Bevanda", "doControl", request);
	}
	
}
