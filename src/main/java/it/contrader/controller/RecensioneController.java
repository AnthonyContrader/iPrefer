package it.contrader.controller;

import it.contrader.service.RecensioneService;
import java.util.List;
import it.contrader.dto.RecensioneDTO;
import it.contrader.main.MainDispatcher;

public class RecensioneController implements Controller {

	private static String sub_package = "recensione.";

	private RecensioneService recensioneService;

	/**
	 * Costruisce un oggetto di tipo RecensioneService per poterne usare i metodi
	 */
	public RecensioneController() {
		this.recensioneService = new RecensioneService();
	}

	@Override
	public void doControl(Request request) {

		// Estrae dalla request mode e choice
		String mode = (String) request.get("mode");

		String choice = (String) request.get("choice");

		// Definisce i campi della classe (serviranno sempre, tanto vale definirli una
		// sola volta)
		int id_recensione;
		int voto, id_ordinazione;
		String testo;

		switch (mode) {

		case "READ":
			id_recensione = Integer.parseInt(request.get("id_recensione").toString());
			RecensioneDTO recensioneDTO = recensioneService.read(id_recensione);
			request.put("recensione", recensioneDTO);
			MainDispatcher.getInstance().callView(sub_package + "RecensioneRead", request);
			break;

		case "INSERT":
			voto = Integer.parseInt(request.get("voto").toString());
			id_ordinazione = Integer.parseInt(request.get("id_ordinazione").toString());
			testo = request.get("testo").toString();
			

			RecensioneDTO recensionetoinsert = new RecensioneDTO(voto, id_ordinazione, testo);
			
			recensioneService.insert(recensionetoinsert);
			request = new Request();
			request.put("mode", "mode");
			
			MainDispatcher.getInstance().callView(sub_package + "RecensioneInsert", request);
			break;

		case "DELETE":
			id_recensione = Integer.parseInt(request.get("id_recensione").toString());
			recensioneService.delete(id_recensione);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "RecensioneDelete", request);
			break;

		case "UPDATE":
			id_recensione = Integer.parseInt(request.get("id_recensione").toString());
			voto = Integer.parseInt(request.get("voto").toString());
			id_ordinazione = Integer.parseInt(request.get("id_ordinazione").toString());
			testo = request.get("testo").toString();
			RecensioneDTO recensionetoupdate = new RecensioneDTO(voto,id_ordinazione, testo);
			recensionetoupdate.setId_recensione(id_recensione);
			recensioneService.update(recensionetoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "RecensioneUpdate", request);
			break;

		case "RECENSIONELIST":
			List<RecensioneDTO> recensioniDTO = recensioneService.getAll();
			request.put("recensioni", recensioniDTO);
			MainDispatcher.getInstance().callView("Recensione", request);
			break;

		case "GETCHOICE":

			switch (choice.toUpperCase()) {

			case "L":
				MainDispatcher.getInstance().callView(sub_package + "RecensioneRead", null);
				break;

			case "I":
				MainDispatcher.getInstance().callView(sub_package + "RecensioneInsert", null);
				break;

			case "M":
				MainDispatcher.getInstance().callView(sub_package + "RecensioneUpdate", null);
				break;

			case "C":
				MainDispatcher.getInstance().callView(sub_package + "RecensioneDelete", null);
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
