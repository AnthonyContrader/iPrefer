package it.contrader.controller;

import java.util.List;

import it.contrader.dto.PrenotazioneDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.PrenotazioneService;

	//@author Samuel
	
public class PrenotazioneController implements Controller {
	
	private static String sub_package = "prenotazione.";
	
	private PrenotazioneService prenotazioneService;
	
	public PrenotazioneController() {
		this.prenotazioneService = new PrenotazioneService();
	}
	
	
	@Override
	public void doControl (Request request) {
		
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");
		
		
		int id_prenotazione;
		String data_ora;
		int tavolo;
		int id_cliente;
		
		switch (mode) {
		
		
		case "READ":
			id_prenotazione = Integer.parseInt(request.get("id_prenotazione").toString());
			PrenotazioneDTO prenotazioneDTO = prenotazioneService.read(id_prenotazione);
			request.put("prenotazione", prenotazioneDTO);
			MainDispatcher.getInstance().callView(sub_package + "PrenotazioneRead", request);
			break;
			
		case "INSERT":
			data_ora = request.get("data_ora").toString();
			tavolo = Integer.parseInt(request.get("tavolo").toString());
			id_cliente = Integer.parseInt(request.get("id_cliente").toString());
			
			PrenotazioneDTO prenotazionetoinsert = new PrenotazioneDTO(data_ora, tavolo, id_cliente);
			prenotazioneService.insert(prenotazionetoinsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "PrenotazioneInsert", request);
			break;
			
		case "DELETE":
			id_prenotazione = Integer.parseInt(request.get("id_prenotazione").toString());
			prenotazioneService.delete(id_prenotazione);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "PrenotazioneDelete", request);
			break;
			
		case "UPDATE":
			id_prenotazione = Integer.parseInt(request.get("id_prenotazione").toString());
			data_ora = request.get("data_ora").toString();
			tavolo = Integer.parseInt(request.get("tavolo").toString());
			id_cliente = Integer.parseInt(request.get("id_cliente").toString());
			PrenotazioneDTO prenotazionetoupdate = new PrenotazioneDTO (data_ora, tavolo, id_cliente);
			prenotazionetoupdate.setId_prenotazione(id_prenotazione);
			prenotazioneService.update(prenotazionetoupdate);
			request = new Request();
			request.put("mode","mode");
			MainDispatcher.getInstance().callView(sub_package + "PrenotazioneUpdate", request);
			break;
			
		case "PRENOTAZIONELIST":
			List<PrenotazioneDTO> prenotazioniDTO = prenotazioneService.getAll();
			request.put("prenotazioni", prenotazioniDTO);
			MainDispatcher.getInstance().callView("Prenotazione", request);
			break;
			
		case"GETCHOICE":
				
			switch (choice.toUpperCase()) {
				
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "PrenotazioneRead", null);
				break;
					
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "PrenotazioneInsert", null);
				break;
					
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "PrenotazioneUpdate", null);
				break;
					
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "PrenotazioneDelete", null);
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
