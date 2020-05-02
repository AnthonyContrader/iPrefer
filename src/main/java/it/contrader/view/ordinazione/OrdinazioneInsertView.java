package it.contrader.view.ordinazione;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class OrdinazioneInsertView  extends AbstractView{

	
	private Request request;
	private int id_piatto,id_bevanda,id_cliente;
	private String data_ora;
	private float costo_tot;
	private final String mode = "INSERT";

	public OrdinazioneInsertView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Ordinazione", null);
		}
	}

	@Override
	public void showOptions() {
			System.out.println("Inserisci id_piatto:");
			id_piatto = Integer.parseInt(getInput());
			System.out.println("Inserisci id_bevanda:");
			id_bevanda = Integer.parseInt(getInput());
			System.out.println("Inserisci id_cliente:");
			id_cliente = Integer.parseInt(getInput());
			System.out.println("Inserisci data_ora:");
			data_ora = getInput();
			System.out.println("Inserisci costo_tot:");
			costo_tot = Float.parseFloat(getInput());
	}
	
	@Override
	public void submit() {
	    request= new Request();
		request.put("id_piatto", id_piatto);
		request.put("id_bevanda", id_bevanda);
		request.put("id_cliente", id_cliente);
		request.put("data_ora", data_ora);
		request.put("costo_tot", costo_tot);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Ordinazione", "doControl", request);
	}

	
}
