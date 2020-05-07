package it.contrader.dto;

public class ClienteDTO {
	private int id_cliente;
	private String nome_cliente;
	private String cognome_cliente;
	private boolean intolleranza_bool;
	private String telefono;
	private String intollerante;
	
	public ClienteDTO() {
		
	}
	
	public ClienteDTO(String nomeCliente, String cognomeCliente, boolean intolleranza, String telefono, String intollerante ){
			this.nome_cliente=nomeCliente;
			this.cognome_cliente=cognomeCliente;
			this.intolleranza_bool=intolleranza;
			this.telefono=telefono;
			this.intollerante=intollerante;
	}
	
	public ClienteDTO(int idCliente, String nomeCliente, String cognomeCliente, boolean intolleranza, String telefono, String intollerante ){
		this.id_cliente = idCliente;
		this.nome_cliente=nomeCliente;
		this.cognome_cliente=cognomeCliente;
		this.intolleranza_bool=intolleranza;
		this.telefono=telefono;
		this.intollerante=intollerante;
}
	
	public int getIdCliente() {
		return this.id_cliente;
	}
	public void setIdCliente(int id) {
		this.id_cliente = id;
	}
	
	public void setNomeCliente(String nome) {
		this.nome_cliente=nome;
	}
	
	public String getNomeCliente() {
		return this.nome_cliente;
	}
	
	public void setCognomeCliente(String cognome) {
		 this.cognome_cliente=cognome;
	}
	
	public String getCognomeCliente() {
		return this.cognome_cliente;
	}
	
	public void setIntolleranza(boolean intolleranza) {
		this.intolleranza_bool=intolleranza;
	}
	
	public boolean getIntolleranza() {
		return this.intolleranza_bool;
	}
	
	public void setTelefono(String telefono) {
		this.telefono=telefono;
	}
	
	public String getTelefono() {
		return this.telefono;
	}
	
	public void setIntollerante(String intollerante) {
		this.intollerante=intollerante;
	}
	
	public String getIntollerante() {
		return this.intollerante;
	}
	
	@Override
	public String toString() {
		return "idCliente= " + this.getIdCliente() + "\tnomeCliente= " + this.getNomeCliente() + "\tcognomeCliente= " + this.getCognomeCliente() + "\tintolleranza= " + this.getIntolleranza() + "\ttelefono= " + this.getTelefono() + "\tintolleranze= " + this.getIntollerante();
	}
}
