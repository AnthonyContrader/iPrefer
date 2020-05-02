package it.contrader.controller;

import java.util.List;

import it.contrader.dto.PiattoDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.PiattoService;


/**
 * 
 * @author Santo
 *
 *Si osservi che nel Controller compaiono solo oggetti del DTO e non del Model!
 */
public class PiattoController implements Controller {

	/**
	 * definisce il pacchetto di vista piatto.
	 */
	private static String sub_package = "piatto.";
	
	private PiattoService piattoService;
	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	public PiattoController() {
		this.piattoService = new PiattoService();
	}
	
	
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int id_piatto;
		String nome_piatto;
		String ingredienti;
		float costo_piatto;
		String descrizione_piatto;

		switch (mode) {
		
		// Arriva qui dalla PiattoReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			id_piatto = Integer.parseInt(request.get("id_piatto").toString());
			PiattoDTO piattoDTO = piattoService.read(id_piatto);
			request.put("piatto", piattoDTO);
			MainDispatcher.getInstance().callView(sub_package + "PiattoRead", request);
			break;
		
		// Arriva qui dalla PiattoInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			nome_piatto = request.get("nome_piatto").toString();
			ingredienti = request.get("ingredienti").toString();
			costo_piatto = Float.parseFloat(request.get("costo_piatto").toString());
			descrizione_piatto = request.get("descrizione_piatto").toString();
			//costruisce l'oggetto user da inserire
			PiattoDTO piattoDaInserire = new PiattoDTO(nome_piatto, ingredienti, costo_piatto, descrizione_piatto);
			//invoca il service
			piattoService.insert(piattoDaInserire);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "PiattoInsert", request);
			break;
		
		// Arriva qui dalla PiattoDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			id_piatto = Integer.parseInt(request.get("id_piatto").toString());
			//Qui chiama il service
			piattoService.delete(id_piatto);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "PiattoDelete", request);
			break;
		
		// Arriva qui dalla PiattoUpdateView
		case "UPDATE":
			id_piatto = Integer.parseInt(request.get("id_piatto").toString());
			nome_piatto = request.get("nome_piatto").toString();
			ingredienti = request.get("ingredienti").toString();
			costo_piatto = Float.parseFloat(request.get("costo_piatto").toString());
			descrizione_piatto = request.get("descrizione_piatto").toString();
			PiattoDTO piattoDaModificare = new PiattoDTO(id_piatto, nome_piatto, ingredienti, costo_piatto, descrizione_piatto);
			//piattoDaModificare.setId(id);
			piattoService.update(piattoDaModificare);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "PiattoUpdate", request);
			break;
			
		//Arriva qui dalla PiattoView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "PIATTOLIST":
			List<PiattoDTO> piattiDTO = piattoService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("piatti", piattiDTO);
			MainDispatcher.getInstance().callView("Piatto", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "PiattoRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "PiattoInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "PiattoUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "PiattoDelete", null);
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