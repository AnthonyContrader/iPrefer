package it.contrader.controller;

import java.util.List;

import it.contrader.dto.OrdinazioneDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.OrdinazioneService;

public class OrdinazioneController implements Controller {

	
	
	private static String sub_package = "ordinazione.";
	
	private OrdinazioneService ordinazioneService;

	public OrdinazioneController() {
		this.ordinazioneService = new OrdinazioneService();
	}
	
	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		
		int id_ordinazione;
		int id_piatto,id_bevanda,id_cliente;
		String data_ora;
		float costo_tot;
		
		switch(mode) {
		case "READ":
			id_ordinazione=Integer.parseInt(request.get("id_ordinazione").toString());
			OrdinazioneDTO ordinazioneDTO=ordinazioneService.read(id_ordinazione);
			request.put("ordinazione", ordinazioneDTO);
			MainDispatcher.getInstance().callView(sub_package + "OrdinazioneRead", request);
			break;
			
		case "INSERT":
			id_piatto = Integer.parseInt(request.get("id_piatto").toString());
			id_bevanda = Integer.parseInt(request.get("id_bevanda").toString());
			id_cliente = Integer.parseInt(request.get("id_cliente").toString());
			data_ora = request.get("data_ora").toString();
			costo_tot = Float.parseFloat(request.get("costo_tot").toString());
			
			OrdinazioneDTO ordinazionetoinsert = new OrdinazioneDTO(id_piatto, id_bevanda, id_cliente,data_ora,costo_tot);
			ordinazioneService.insert(ordinazionetoinsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "OrdinazioneInsert", request);
			break;
			
		case "DELETE":
			id_ordinazione = Integer.parseInt(request.get("id_ordinazione").toString());
			ordinazioneService.delete(id_ordinazione);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "OrdinazioneDelete", request);
			break;
			
		case "UPDATE":
			id_ordinazione= Integer.parseInt(request.get("id_ordinazione").toString());
			id_piatto= Integer.parseInt(request.get("id_piatto").toString());
			id_bevanda= Integer.parseInt(request.get("id_bevanda").toString());
			id_cliente= Integer.parseInt(request.get("id_cliente").toString());
			data_ora=request.get("data_ora").toString();
			costo_tot=Float.parseFloat(request.get("costo_tot").toString());
		
			OrdinazioneDTO ordinazionetoupdate = new OrdinazioneDTO(id_piatto, id_bevanda,id_cliente,data_ora,costo_tot);
			ordinazionetoupdate.setId_ordinazione(id_ordinazione);
			ordinazioneService.update(ordinazionetoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "OrdinazioneUpdate", request);
			break;
			
		case "ORDINAZIONILIST":
			List<OrdinazioneDTO> ordinazioniDTO = ordinazioneService.getAll();
			request.put("ordinazioni", ordinazioniDTO);
			MainDispatcher.getInstance().callView("Ordinazione", request);
			break;
			
		case "GETCHOICE":
			switch (choice.toUpperCase()) {
			case "L":
				
				MainDispatcher.getInstance().callView(sub_package + "OrdinazioneRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "OrdinazioneInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "OrdinazioneUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "OrdinazioneDelete", null);
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
	
	

