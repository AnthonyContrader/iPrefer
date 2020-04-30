package it.contrader.model;

public class Recensione {

	private int id_recensione;
	private int voto;
	private int id_ordinazione;
	private String testo;

	public Recensione() {

	}

	public Recensione(int voto,int id_ordinazione, String testo) {
		this.voto = voto;
		this.id_ordinazione = id_ordinazione;
		this.testo = testo;
	}

	public Recensione(int id_recensione, int voto,int id_ordinazione, String testo) {
		this.id_recensione = id_recensione;
		this.voto = voto;
		this.id_ordinazione = id_ordinazione;
		this.testo = testo;
	}

	public int getId_ordinazione() {
		return id_ordinazione;
	}

	public void setId_ordinazione(int id_ordinazione) {
		this.id_ordinazione = id_ordinazione;
	}

	public int getId_recensione() {
		return id_recensione;
	}

	public void setId_recensione(int id_recensione) {
		this.id_recensione = id_recensione;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}


	
	@Override
	public String toString() {
		return "Recensione [id_recensione=" + id_recensione + ", voto=" + voto + ", id_ordinazione=" + id_ordinazione
				+ ", testo=" + testo + "]";
	}

	//Metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recensione other = (Recensione) obj;
		if (id_recensione != other.id_recensione)
			return false;
		if(voto == 0) {
			if(other.voto != 0)
				return false;
		}else if (voto != other.voto)
				return false;
		if(id_recensione == 0) {
			if(other.id_ordinazione != 0)
				return false;
		}else if(id_ordinazione != other.id_ordinazione)
			return false;
		if (testo == null) {
			if (other.testo != null)
				return false;
		} else if (!testo.equals(other.testo))
			return false;
		return true;
	}
}
