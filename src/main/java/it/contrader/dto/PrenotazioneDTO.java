package it.contrader.dto;


public class PrenotazioneDTO {

	private int id_prenotazione;
	
	private String data_ora;
	
	private int tavolo;
	
	private int id_cliente;
	
	
	public PrenotazioneDTO() {
		
	}
	
	public PrenotazioneDTO(int id_prenotazione, String data_ora, int tavolo, int id_cliente) {
		this.id_prenotazione = id_prenotazione;
		this.data_ora = data_ora;
		this.tavolo = tavolo;
		this.id_cliente = id_cliente;
	}
	
	public PrenotazioneDTO(String data_ora, int tavolo, int id_cliente) {
		this.data_ora = data_ora;
		this.tavolo = tavolo;
		this.id_cliente = id_cliente;
	}

	//Getter e setter
	
	public int getId_prenotazione() {
		return id_prenotazione;
	}

	public void setId_prenotazione(int id_prenotazione) {
		this.id_prenotazione = id_prenotazione;
	}

	public String getData_ora() {
		return data_ora;
	}

	public void setData_ora(String data_ora) {
		this.data_ora = data_ora;
	}

	public int getTavolo() {
		return tavolo;
	}

	public void setTavolo(int tavolo) {
		this.tavolo = tavolo;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	
	@Override
	public String toString() {
		return  id_prenotazione + "\t\t\t"  + data_ora +"\t\t" + tavolo + "\t\t" + id_cliente ;
	}
	

}
