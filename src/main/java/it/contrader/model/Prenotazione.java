package it.contrader.model;

	//@author Samuel

public class Prenotazione {

	private int id_prenotazione;
	
	private String data_ora;
	
	private int tavolo;
	
	private int id_cliente;
	
	
	//Metodo Costruttore
	public Prenotazione() {
		
	}
	
	public Prenotazione (int id_prenotazione,String data_ora, int tavolo, int id_cliente) {
		this.id_prenotazione = id_prenotazione;
		this.data_ora = data_ora;
		this.tavolo = tavolo;
		this.id_cliente = id_cliente;
	}
	
	public Prenotazione (String data_ora, int tavolo, int id_cliente) {
		this.data_ora = data_ora;
		this.tavolo = tavolo;
		this.id_cliente = id_cliente;
	}
	
	
	//Getter e Setter
	public int getId_prenotazione() {
		return this.id_prenotazione;
	}
	
	public void setId_prenotazione(int id_prenotazione) {
		this.id_prenotazione = id_prenotazione;
	}
	
	public String getData_ora() {
		return this.data_ora;
	}
	
	public void setData_ora( String data_ora) {
		this.data_ora = data_ora;
	}
	
	public int getTavolo() {
		return this.tavolo;
	}
	
	public void setTavolo(int tavolo) {
		this.tavolo = tavolo;
	}
	
	public int getId_cliente() {
		return this.id_cliente;
	}
	
	public void setId_cliente( int id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	//Trasforma oggetto in stringa
	@Override
	public String toString() {
		return  id_prenotazione + "\t\t\t"  + data_ora +"\t\t" + tavolo + "\t\t" + id_cliente ;
	}
	
	//Metodo confronto oggetti
	@Override
	public boolean equals(Object obj) {
		if (this==obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prenotazione other = (Prenotazione) obj;
		if (id_prenotazione != other.id_prenotazione)
			return false;
		if (data_ora==null) {
			if (other.data_ora != null)
				return false;
		} else if (!data_ora.equals(other.data_ora))
			return false;
		if (tavolo == 0) {
			if (other.tavolo != 0)
			return false;
		} else if (tavolo != other.tavolo)
			return false;
		if (id_cliente == 0) {
			if (other.id_cliente != 0)
			return false;
		} else if (id_cliente != other.id_cliente)
			return false;
		
		return true;
	}
}