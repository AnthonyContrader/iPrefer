package it.contrader.view.bevanda;

import it.contrader.controller.Request;
import it.contrader.dto.BevandaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * @author Simone
 *
 */
public class BevandaReadView extends AbstractView{

	private int id_bevanda;
	private Request request;
	private final String mode = "READ";
	
	public BevandaReadView() {
		
	}
	@Override
	public void showResults(Request request) {
		if (request != null) {
			BevandaDTO bevanda = (BevandaDTO) request.get("bevanda");
			System.out.println(bevanda);
			MainDispatcher.getInstance().callView("Bevanda", null);
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("Inserire l'ID della bevanda da leggere");
		id_bevanda = Integer.parseInt(getInput());
		
	}
	@Override
	public void submit() {
		request = new Request();
		request.put("id_bevanda", id_bevanda);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Bevanda", "doControl", request);
	}
}
