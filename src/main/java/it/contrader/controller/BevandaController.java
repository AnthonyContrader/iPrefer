package it.contrader.controller;

import java.util.List;

import it.contrader.dto.BevandaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.BevandaService;
/**
 * 
 * @author simone
 *
 */
public class BevandaController implements Controller {
	//definisce il pacchetto di vista Bevanda
	private static String sub_package = "bevanda.";
	private BevandaService bevandaService;
	//Costruisce un oggetto di tipo Bevanda per porterne usare i metodi
	public BevandaController() {
		this.bevandaService = new BevandaService();
	}
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode e la scelta dell'utente.
	 */
	@Override
	public void doControl(Request request) {
		//Estrae dalla request mode e choise
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		
		// definisce i campi della classe
		int id_bevanda;
		String nome_bevanda;
		float costo_bevanda;
		boolean alcolico;
		String descrizione;
		
		switch (mode) {
		//Arriva qui dalla UserReadView. 
		case "READ":
			id_bevanda =Integer.parseInt(request.get("id_bevanda").toString());
			BevandaDTO bevandaDTO = bevandaService.read(id_bevanda);
			request.put("bevanda", bevandaDTO);
			MainDispatcher.getInstance().callView(sub_package +"BevandaRead", request);
			break;
			
			//arriva qui dalla BevandaInsertView. Estrae i paramentri da inserire
		case "INSERT":
			nome_bevanda = request.get("nome_bevanda").toString();
			costo_bevanda = Float.parseFloat(request.get("costo_bevanda").toString());
			alcolico = Boolean.parseBoolean(request.get("alcolico").toString());
			descrizione = request.get("descrizione").toString();
			//costruisce l'oggetti bevanda da inserire
			BevandaDTO bevandatoinsert =new BevandaDTO(nome_bevanda, costo_bevanda ,alcolico, descrizione);
			//invoca il service
			bevandaService.insert(bevandatoinsert);
			request = new Request();
			request.put("mode", "mode");
			// Rimanda alla view con la risposta 
			MainDispatcher.getInstance().callView(sub_package + "BevandaInsert", request);
			break;
			
		case "DELETE":
			id_bevanda = Integer.parseInt(request.get("id_bevanda").toString());
			//Qui chiama il service
			bevandaService.delete(id_bevanda);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "BevandaDelete", request);
			break;
			
			//arriva qui dalla BevandaUpdateView
		case"UPDATE":
			id_bevanda= Integer.parseInt(request.get("id_bevanda").toString());
			nome_bevanda = request.get("nome_bevanda").toString();
			costo_bevanda = Float.parseFloat(request.get("costo_bevanda").toString());
			alcolico = Boolean.parseBoolean(request.get("alcolico").toString());
			descrizione = request.get("descrizione").toString();
			BevandaDTO bevandatoupdate = new BevandaDTO(nome_bevanda, costo_bevanda ,alcolico, descrizione);
			bevandatoupdate.setId_Bevanda(id_bevanda);
			bevandaService.update(bevandatoupdate);
			request= new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "BevandaUpdate", request);
			break;
			
		case"BEVANDALIST":
			List<BevandaDTO> bevandeDTO = bevandaService.getAll();
			request.put("bevande",bevandeDTO);
			MainDispatcher.getInstance().callView("Bevanda", request);
			break;
			//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		case"GETCHOICE":
			
			//toUpperCase mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "BevandaRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "BevandaInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "BevandaUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "BevandaDelete", null);
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
			MainDispatcher.getInstance().callView("Login",null);
		}
	}
}
