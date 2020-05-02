package it.contrader.view.cliente;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ClienteUpdateView extends AbstractView {
	private Request request;

	private int id_cliente;
	private String nome_cliente;
	private String cognome_cliente;
	private boolean intolleranza_bool;
	private String telefono;
	private String intollerante;
	private final String mode = "UPDATE";
	
	public ClienteUpdateView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("User", null);
		}
	}
	
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del cliente:");
			id_cliente = Integer.parseInt(getInput());
			System.out.println("Inserisci nome del cliente:");
			nome_cliente = getInput();
			System.out.println("Inserisci cognome del cliente:");
			cognome_cliente = getInput();
			System.out.println("Inserisci intolleranza del cliente:");
			intolleranza_bool = Boolean.parseBoolean(getInput());
			System.out.println("Inserisci telefono del cliente: ");
			telefono = getInput();
			System.out.println("Inserisci intolleranza del cliente");
			intollerante = getInput();
		} catch (Exception e) {

		}
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id_cliente", id_cliente);
		request.put("nome_cliente", nome_cliente);
		request.put("cognome_cliente", cognome_cliente);
		request.put("intolleranza_bool", intolleranza_bool);
		request.put("telefono", telefono);
		request.put("intollerante", intollerante);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Cliente", "doControl", request);
	}
}
