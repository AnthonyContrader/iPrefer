package it.contrader.dto;

public class OrdinazioneDTO {

		
		private int id_ordinazione;
		private int id_piatto;
		private int id_bevanda;
		private int id_cliente;
		private float costo_tot;
		private String data_ora;
		


		//Metodo Costruttore
		public OrdinazioneDTO() {
			
		}

		public OrdinazioneDTO(int id_piatto,int id_bevanda, int id_cliente, String data_ora, float costo_tot) {
			this.id_piatto=id_piatto;
			this.id_bevanda=id_bevanda;
			this.id_cliente=id_cliente;
			this.costo_tot=costo_tot;
			this.data_ora=data_ora;
		}

		public OrdinazioneDTO(int id_ordinazione,int id_piatto,int id_bevanda,int id_cliente, String data_ora, float costo_tot) {
			this.id_ordinazione=id_ordinazione;
			this.id_piatto=id_piatto;
			this.id_bevanda=id_bevanda;
			this.id_cliente=id_cliente;
			this.costo_tot=costo_tot;
			this.data_ora=data_ora;
		}


		//Metodo GET E SET ID
		public int getId_ordinazione() {
			return this.id_ordinazione;
		}
		public void setId_ordinazione(int id_ordinazione) {
			this.id_ordinazione=id_ordinazione;
		}
		//Metodo GET E SET ID_PIATTO
		public int getId_piatto() {
			return this.id_piatto;
		}
		public void setId_piatto(int id_piatto) {
			this.id_piatto=id_piatto;
		}
		//Metodo GET E SET ID_BEVANDA
		public int getId_bevanda() {
			return this.id_bevanda;
		}
		public void setId_bevanda(int id_bevanda) {
			this.id_bevanda=id_bevanda;
		}
		//Metodo GET E SET ID_CLIENTE
		public int getId_cliente() {
			return this.id_cliente;	
		}
		public void setId_client(int id_cliente) {
			this.id_cliente=id_cliente;
		}
		
		public String getData_ora() {
			return this.data_ora;
		}
		
		public void setData_ora(String data_ora){
			this.data_ora=data_ora;
		} 
		
		public float getCosto_tot() {
			return this.costo_tot;
		}
		
		public void setCosto_tot(float costo_tot){
			this.costo_tot=costo_tot;
		}

		@Override
		public String toString() {
			return   id_ordinazione + "\t" + id_piatto +"\t\t"  +  id_bevanda + "\t\t"  +  id_cliente+ "\t\t" +data_ora + "\t\t"  + costo_tot;
		}

}
