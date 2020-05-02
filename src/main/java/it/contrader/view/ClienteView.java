package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.ClienteDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;

public class ClienteView extends AbstractView {
	private Request request;
	private String choice;
	
public ClienteView() {
		
	}

@Override
public void showResults(Request request) {
	if (request != null) {
		System.out.println("\n------------------- Gestione clienti ----------------\n");
		System.out.println("ID\tNomeCliente\tCognomeCliente\tIntolleranza\tTelefono\tIntollerante");
		System.out.println("----------------------------------------------------\n");
		
		@SuppressWarnings("unchecked")
		List<ClienteDTO> clienti = (List<ClienteDTO>) request.get("clienti");
		for (ClienteDTO u: clienti)
			System.out.println(u);
		System.out.println();
	}
}

@Override
public void showOptions() {
	System.out.println("          Scegli l'operazione da effettuare:");
	System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

	this.choice = getInput();

	
}

@Override
public void submit() {
	request = new Request();
	request.put("choice", choice);
	request.put("mode", "GETCHOICE");
	MainDispatcher.getInstance().callAction("Cliente", "doControl", this.request);
}



}
