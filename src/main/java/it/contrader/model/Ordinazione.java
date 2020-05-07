package it.contrader.model;

public class Ordinazione {

	private int id_ordinazione,id_piatto,id_bevanda,id_cliente;
	private String data_ora;
	private float costo_tot;
	
	public Ordinazione() {}
	
	public Ordinazione(int id_piatto,int id_bevanda,int id_cliente,String data_ora,float costo_tot) {
		this.id_piatto=id_piatto;
		this.id_bevanda=id_bevanda;
		this.id_cliente=id_cliente;
		this.data_ora=data_ora;
		this.costo_tot=costo_tot;
	}
	
	public Ordinazione(int id_ordinazione,int id_piatto,int id_bevanda,int id_cliente,String data_ora,float costo_tot){
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
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Ordinazione other = (Ordinazione) obj;
		if(id_ordinazione != other.id_ordinazione)
			return false;
		
		if(id_piatto == 0) {
			if(other.id_piatto != 0)
				return false;
		} else if(id_piatto != other.id_piatto)
			return false;
		
		if(id_bevanda == 0) {
			if(other.id_bevanda != 0)
				return false;
		} else if(id_bevanda != other.id_bevanda)
			return false;
		
		if(id_cliente == 0) {
			if(other.id_cliente != 0)
				return false;
		} else if(id_cliente != other.id_cliente)
			return false;
		
		if (data_ora == null) {
			if (other.data_ora != null)
				return false;
		} else if (!data_ora.equals(other.data_ora))
			return false;
		
		if(costo_tot == 0.0) {
			if(other.costo_tot != 0.0)
				return false;
		} else if(costo_tot != other.costo_tot)
			return false;
		
		return true;
	}
}
