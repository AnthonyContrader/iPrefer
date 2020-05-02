package it.contrader.model;

public class Cliente {
		private int id_cliente;
		private String nome_cliente;
		private String cognome_cliente;
		private boolean intolleranza_bool;
		private String telefono;
		private String intollerante;
		
		public Cliente() {
			
		}
		
		public Cliente(String nomeCliente, String cognomeCliente, boolean intolleranza, String telefono, String intollerante ){
				this.nome_cliente=nomeCliente;
				this.cognome_cliente=cognomeCliente;
				this.intolleranza_bool=intolleranza;
				this.telefono=telefono;
				this.intollerante=intollerante;
		}
		
		public Cliente(int idCliente, String nomeCliente, String cognomeCliente, boolean intolleranza, String telefono, String intollerante ){
			this.id_cliente=idCliente;
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
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cliente other = (Cliente) obj;
			if (id_cliente != other.id_cliente)
				return false;
			if (nome_cliente == null) {
				if (other.nome_cliente != null)
					return false;
			} else if (!nome_cliente.equals(other.nome_cliente))
				return false;
			if (cognome_cliente == null) {
				if (other.cognome_cliente != null)
					return false;
			} else if (!cognome_cliente.equals(other.cognome_cliente))
				return false;
			if (intolleranza_bool != other.intolleranza_bool ) {
					return false;
			}
			if (telefono == null) {
				if (other.telefono != null)
					return false;
			} else if (!telefono.equals(other.telefono))
				return false;
			
			if (intollerante == null) {
				if (other.intollerante != null)
					return false;
			} else if (!intollerante.equals(other.intollerante))
				return false;
			return true;
		}
}
