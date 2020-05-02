package it.contrader.view.cliente;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ClienteInsertView extends AbstractView {
	private Request request;

	private String nome_cliente;
	private String cognome_cliente;
	private boolean intolleranza_bool;
	private String telefono;
	private String intollerante;
	private final String mode = "INSERT";
	
	public ClienteInsertView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Cliente", null);
		}
	}
	
	@Override
	public void showOptions() {
			System.out.println("Inserisci nome del cliente:");
			nome_cliente = getInput();
			System.out.println("Inserisci cognome del cliente:");
			cognome_cliente = getInput();
			System.out.println("Inserisci True se il cliente da inserire ha intolleranze, False altrimenti:");
			intolleranza_bool = Boolean.parseBoolean(getInput());
			System.out.println("Inserisci numero di telefono del cliente: ");
			telefono = getInput();
			System.out.println("Inserisci l'intolleranza del cliente: ");
			intollerante = getInput();
	}
	
	
		@Override
		public void submit() {
			request = new Request();
			request.put("nome_cliente", nome_cliente);
			request.put("cognome_cliente", cognome_cliente);
			request.put("intolleranza_bool", intolleranza_bool);
			request.put("telefono", telefono);
			request.put("intollerante", intollerante);
			request.put("mode", mode);
			MainDispatcher.getInstance().callAction("Cliente", "doControl", request);
		}

}
