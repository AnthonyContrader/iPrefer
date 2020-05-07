package it.contrader.dto;

public class OrdinazioneDTO {
	
	private int id_ordinazione,id_piatto,id_bevanda,id_cliente;
	private String data_ora;
	private float costo_tot;
	
	public OrdinazioneDTO() {}
	
	public OrdinazioneDTO(int id_piatto,int id_bevanda,int id_cliente,String data_ora,float costo_tot) {
		this.id_piatto=id_piatto;
		this.id_bevanda=id_bevanda;
		this.id_cliente=id_cliente;
		this.data_ora=data_ora;
		this.costo_tot=costo_tot;
	}
	
	public OrdinazioneDTO(int id_ordinazione,int id_piatto,int id_bevanda,int id_cliente,String data_ora,float costo_tot){
		this.id_ordinazione=id_ordinazione;
		this.id_piatto=id_piatto;
		this.id_bevanda=id_bevanda;
		this.id_cliente=id_cliente;
		this.data_ora=data_ora;
		this.costo_tot=costo_tot;
	}
	
	public int GetId_Ordinazione(){
		return this.id_ordinazione;
	}
	
	public void SetId_Ordinazione(int id_ordinazione) {
		this.id_ordinazione=id_ordinazione;
	}
	
	public int GetId_Piatto() {
		return this.id_piatto;
		}
	
	public void SetId_Piatto(int id_piatto) {
		this.id_piatto=id_piatto;
	}
	
	public int GetId_Bevanda() {
		return this.id_bevanda;
	}
	
	public void SetId_Bevanda(int id_bevanda) {
		this.id_bevanda=id_bevanda;
	}
	
	public int GetId_Cliente() {
		return this.id_cliente;
	}
	
	public void SetId_Cliente(int id_cliente) {
		this.id_cliente=id_cliente;
	}
	
	public String GetData_ora() {
		return this.data_ora;
	}
	
	public void SetData_ora(String data_ora) {
		this.data_ora=data_ora;
	}
	
	public float GetCosto_tot() {
		return this.costo_tot;
	}
	
	public void SetCosto_tot(float costo_tot) {
		this.costo_tot=costo_tot;
	}
	
	@Override
	public String toString() {
		return id_ordinazione + "\t\t" + id_piatto + "\t\t" + id_bevanda + "\t\t" + id_cliente + "\t\t" + data_ora + "\t\t" + costo_tot;
	}
	

}
