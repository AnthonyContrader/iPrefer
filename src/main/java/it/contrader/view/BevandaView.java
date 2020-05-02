package it.contrader.view;

import java.util.List;
import it.contrader.controller.Request;
import it.contrader.dto.BevandaDTO;
import it.contrader.main.MainDispatcher;
/**
 * 
 * @author simone
 *
 */
public class BevandaView extends AbstractView{

	private Request request;
	private String choice;
	
	public BevandaView() {
		
	}
	//mostra la lita bevande
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione bevande ----------------\n");
			System.out.println("ID\tNome\tCosto\tAlcolico\tDescrizione");
			System.out.println("-------------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<BevandaDTO> bevande = (List<BevandaDTO>) request.get("bevande");
			for(BevandaDTO b:bevande)
				System.out.println(b);
			System.out.println();
		}
	}
		/**
		 * Chiede all'utente un input 
		 * Mette la modalità GETCHOICE nella mode.
		 */
		@Override
		public void showOptions() {
			System.out.println("          Scegli l'operazione da effettuare:");
			System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

			this.choice = getInput();

			
		}
		/**
		 * Impacchetta la request e la manda allo BevandaController.
		 */
		@Override
		public void submit() {
			request = new Request();
			request.put("choice", choice);
			request.put("mode", "GETCHOICE");
			MainDispatcher.getInstance().callAction("Bevanda", "doControl", this.request);
	}
}
