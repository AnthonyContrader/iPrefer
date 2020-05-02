package it.contrader.view.cliente;

import it.contrader.controller.Request;

import it.contrader.dto.ClienteDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ClienteReadView extends AbstractView{
	private int idCliente;
	private Request request;
	private final String mode = "READ";

	
	public ClienteReadView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			ClienteDTO cliente = (ClienteDTO) request.get("cliente");
			System.out.println(cliente);
			MainDispatcher.getInstance().callView("Cliente", null);
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del cliente:");
		idCliente = Integer.parseInt(getInput());
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("idCliente", idCliente);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Cliente", "doControl", request);
	}
	
}
