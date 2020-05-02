package it.contrader.view.ordinazione;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class OrdinazioneUpdateView extends AbstractView {
	
	private Request request;

	private int id_ordinazione,id_piatto,id_bevanda,id_cliente;
	private String data_ora;
	private float costo_tot;
	private final String mode = "UPDATE";

	public OrdinazioneUpdateView() {
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Ordinazione", null);
		}
	}
	
	public void showOptions() {
		try {
			System.out.println("Inserisci id dell'ordine:");
			id_ordinazione = Integer.parseInt(getInput());
			System.out.println("Inserisci id del piatto:");
			id_piatto = Integer.parseInt(getInput());
			System.out.println("Inserisci id della bevanda:");
			id_bevanda = Integer.parseInt(getInput());
			System.out.println("Inserisci id del cliente:");
			id_cliente = Integer.parseInt(getInput());
			System.out.println("Inserisci data_ora dell'ordine:");
			data_ora = getInput();
			System.out.println("Inserisci costo dell'ordine:");
			costo_tot =Float.parseFloat( getInput());
		} catch (Exception e) {

		}

}
	@Override
	public void submit() {
		request = new Request();
		request.put("id_ordinazione", id_ordinazione);
		request.put("id_piatto", id_piatto);
		request.put("id_bevanda", id_bevanda);
		request.put("id_cliente", id_cliente);
		request.put("data_ora", data_ora);
		request.put("costo_tot", costo_tot);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Ordinazione", "doControl", request);
	}

}

