package it.contrader.view.ordinazione;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class OrdinazioneDeleteView  extends AbstractView{
	private Request request;

	private int id_ordinazione;
	private final String mode = "DELETE";
	
	public OrdinazioneDeleteView() {
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Ordinazione", null);
		}
	}
	
	@Override
	public void showOptions() {
			System.out.println("Inserisci id dell'ordinazione:");
			id_ordinazione= Integer.parseInt(getInput());
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id_ordinazione", id_ordinazione);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Ordinazione", "doControl", request);
	}

}
