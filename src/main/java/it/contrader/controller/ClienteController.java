package it.contrader.controller;

import java.util.List;

import it.contrader.dto.ClienteDTO;

import it.contrader.main.MainDispatcher;
import it.contrader.service.ClienteService;



public class ClienteController implements Controller {
	private static String sub_package = "cliente.";
	
	private ClienteService clienteService;
	
	public ClienteController() {
		this.clienteService = new ClienteService();
	}
	
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int idCliente;
		String nomeCliente ;
		String cognomeCliente;
		boolean intolleranza;
		String telefono;
		String intollerante;

		switch (mode) {
		
		// Arriva qui dalla ClienteReadView. Invoca il Service con il parametro id e invia alla ClienteReadView un cliente da mostrare 
		case "READ":
			idCliente = Integer.parseInt(request.get("idCliente").toString());
			ClienteDTO clienteDTO = clienteService.read(idCliente);
			request.put("cliente",clienteDTO);
			MainDispatcher.getInstance().callView(sub_package + "ClienteRead", request);
			break;
		
		// Arriva qui dalla ClienteInsertView. Estrae i parametri da inserire e chiama il service per inserire un cliente con questi parametri
		case "INSERT":
			nomeCliente = request.get("nome_cliente").toString();
			cognomeCliente = request.get("cognome_cliente").toString();
			intolleranza = Boolean.parseBoolean(request.get("intolleranza_bool").toString());
			telefono = request.get("telefono").toString();
			intollerante = request.get("intollerante").toString();
			
			
			//costruisce l'oggetto cliente da inserire
			ClienteDTO clientetoinsert = new ClienteDTO(nomeCliente, cognomeCliente, intolleranza, telefono, intollerante);
			//invoca il service
			clienteService.insert(clientetoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "ClienteInsert", request);
			break;
		
		// Arriva qui dalla ClienteDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			idCliente = Integer.parseInt(request.get("id_cliente").toString());
			//Qui chiama il service
			clienteService.delete(idCliente);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ClienteDelete", request);
			break;
		
		// Arriva qui dalla ClienteUpdateView
		case "UPDATE":
			idCliente = Integer.parseInt(request.get("id_cliente").toString());
			nomeCliente = request.get("nome_cliente").toString();
			cognomeCliente = request.get("cognome_cliente").toString();
			intolleranza = Boolean.parseBoolean(request.get("intolleranza_bool").toString());
			telefono = request.get("telefono").toString();
			intollerante = request.get("intollerante").toString();
			ClienteDTO clientetoupdate = new ClienteDTO(nomeCliente, cognomeCliente, intolleranza, telefono, intollerante);
			clientetoupdate.setIdCliente(idCliente);
			clienteService.update(clientetoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ClienteUpdate", request);
			break;
			
		//Arriva qui dalla ClienteView Invoca il Service e invia alla ClienteView il risultato da mostrare 
		case "CLIENTELIST":
			List<ClienteDTO> clientiDTO = clienteService.getAll();
			//Impacchetta la request con la lista dei CLIENTI
			request.put("clienti", clientiDTO);
			MainDispatcher.getInstance().callView("Cliente", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "ClienteRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "ClienteInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "ClienteUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "ClienteDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
	
}
