/**
 * Manage a Business Owner view
 */

package it.contrader.view;


/**
 * Per Ulteriori dettagli vedi Guida sez 9 View.
 * Per la descrizione dei metodi vedi l'interfaccia View in questo pacchetto.
 */
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeAdminView extends AbstractView {

    private String choice;
    
	private Request request;

	/**
	 * Se la request non è nulla mostra un messaggio di benvenuto
	 */
    public void showResults(Request request) {
    	if(request!=null) {
    	System.out.println("\n Benvenuto in SAMPLE PROJECT "+request.get("username").toString() + "\n");
    	}
    }


    /**
     * Chiede all'utente di effettuare una scelta (da console)
     */
    public void showOptions() {
        System.out.println("-------------MENU------------\n");
        System.out.println(" Seleziona cosa vuoi gestire:");
        System.out.println("[U]tenti [B]evande [C]lienti [O]rdinazioni [P]iatti [X]prenotazioni [R]ecensioni [E]sci");
        //Il metodo che salva l'input nella stringa choice.
        //getInput() è definito in AbstractView.
        choice = this.getInput();
    }

    /**
     * Impacchetta una request (in base alla scelta sarà diversa) che invia ai controller tramite il
     * Dispatcher
     */
    public void submit() {    
    	//crea una nuova Request (vedi classe Request)
    	request = new Request();
        switch (choice) {
        case "u":
        	this.request.put("mode", "USERLIST");
        	MainDispatcher.getInstance().callAction("User", "doControl", request);
        	break;
        	
        case "r":
        	this.request.put("mode", "RECENSIONELIST");
        	MainDispatcher.getInstance().callAction("Recensione", "doControl", request);
        	break;
 
        case "b":
        	this.request.put("mode", "BEVANDALIST");
        	MainDispatcher.getInstance().callAction("Bevanda", "doControl", request);
        	break;
        	
        case "c":
        	this.request.put("mode", "CLIENTELIST");
        	MainDispatcher.getInstance().callAction("Cliente", "doControl", request);
        	break;
        	
        case "o":
        	this.request.put("mode", "ORDINAZIONILIST");
        	MainDispatcher.getInstance().callAction("Ordinazione", "doControl", request);
        	break;
        	
        case "p":
        	this.request.put("mode", "PIATTOLIST");
        	MainDispatcher.getInstance().callAction("Piatto", "doControl", request);
        	break;
        	
        case "x":
        	this.request.put("mode", "PRENOTAZIONELIST");
        	MainDispatcher.getInstance().callAction("Prenotazione", "doControl", request);
        	break;
        	
        case "e":
        	MainDispatcher.getInstance().callAction("Login", "doControl", null);
        	break;
        default:
        	
            request.put("choice", choice);
        	MainDispatcher.getInstance().callAction("Login", "doControl", request);
        }
    }
}
