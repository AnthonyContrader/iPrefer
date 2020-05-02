package it.contrader.view.piatto;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class PiattoUpdateView extends AbstractView {
	private Request request;

	private int id_piatto;
	private String nome_piatto;
	private String ingredienti;
	private float costo_piatto;
	private String descrizione_piatto;
	private final String mode = "UPDATE";

	public PiattoUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Piatto", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi del piatto da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci l'id del piatto:");
			id_piatto = Integer.parseInt(getInput());
			System.out.println("Inserisci il nome del piatto:");
			nome_piatto = getInput();
			System.out.println("Inserisci gli ingredienti del piatto:");
			ingredienti = getInput();
			System.out.println("Inserisci il costo del piatto:");
			costo_piatto = Float.parseFloat(getInput());
			System.out.println("Inserisci la descrizione del piatto:");
			descrizione_piatto = getInput();
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id_piatto", id_piatto);
		request.put("nome_piatto", nome_piatto);
		request.put("ingredienti", ingredienti);
		request.put("costo_piatto", costo_piatto);
		request.put("descrizione_piatto", descrizione_piatto);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Piatto", "doControl", request);
	}

}
