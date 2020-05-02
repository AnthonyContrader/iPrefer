package it.contrader.view.cliente;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ClienteDeleteView extends AbstractView {
	
	private Request request;

	private int id;
	private final String mode = "DELETE";

	public ClienteDeleteView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Cliente", null);
		}
	}
	
	@Override
	public void showOptions() {
			System.out.println("Inserisci id del cliente:");
			id = Integer.parseInt(getInput());

	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id_cliente", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Cliente", "doControl", request);
	}
	
}
