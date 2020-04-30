package it.contrader.dto;

public class RecensioneDTO {

	private int id_recensione;
	private int voto;
	private int id_ordinazione;
	private String testo;

	public RecensioneDTO() {

	}

	public RecensioneDTO(int voto, int id_ordinazione, String testo) {
		this.voto = voto;
		this.id_ordinazione = id_ordinazione;
		this.testo = testo;
	}

	public RecensioneDTO(int id_recensione, int voto, int id_ordinazione, String testo) {
		this.id_recensione = id_recensione;
		this.voto = voto;
		this.id_ordinazione = id_ordinazione;
		this.testo = testo;
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

	public int getId_ordinazione() {
		return id_ordinazione;
	}

	public void setId_ordinazione(int id_ordinazione) {
		this.id_ordinazione = id_ordinazione;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	@Override
	public String toString() {
		return "RecensioneDTO [id_recensione=" + id_recensione + ", voto=" + voto + ", id_ordinazione=" + id_ordinazione
				+ ", testo=" + testo + "]";
	}

}
