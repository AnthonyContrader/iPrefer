package it.contrader.model;

public class Ordinazione {
	
private int id_ordinazione,id_piatto,id_bevanda, id_cliente;
private float costo_tot;
private String data_ora;

//Metodo Costruttore
public Ordinazione() {
	
}

public Ordinazione(int id_piatto,int id_bevanda, int id_cliente, String data_ora,float costo_tot) {
	this.id_piatto=id_piatto;
	this.id_bevanda=id_bevanda;
	this.id_cliente=id_cliente;
	this.data_ora=data_ora;
	this.costo_tot=costo_tot;

}

public Ordinazione(int id_ordinazione,int id_piatto,int id_bevanda,int id_cliente,String data_ora, float costo_tot) {
	this.id_ordinazione=id_ordinazione;
	this.id_piatto=id_piatto;
	this.id_bevanda=id_bevanda;
	this.id_cliente=id_cliente;
	this.data_ora=data_ora;
	this.costo_tot=costo_tot;

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

public float getCosto_tot() {
	return this.costo_tot;
}
public void setCosto_tot(float costo_tot) {
	this.costo_tot=costo_tot;
}

public String getData_ora() {
	return this.data_ora;
}

public void setData_ora(String data_ora) {
		this.data_ora=data_ora;
}

@Override
public String toString() {
	return  id_ordinazione + "\t"  + id_piatto +"\t\t"  +  id_bevanda + "\t\t"  + id_cliente + "\t\t" + data_ora  + "\t\t" + costo_tot;
}


@Override
public boolean equals(Object obj) {
	
	if(this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Ordinazione other = (Ordinazione) obj;
	
	if (id_ordinazione != other.id_ordinazione) 
	return false;
	
	
	if (id_piatto == 0) {
		if (other.id_piatto != 0)
			return false;
	} else if (id_piatto != other.id_piatto)
		return false;
	
	if (id_bevanda == 0) {
		if (other.id_bevanda != 0)
			return false;
	} else if (id_bevanda != other.id_bevanda)
		return false;
		
	if (id_cliente == 0) {
		if (other.id_cliente != 0)
			return false;
	} else if (id_cliente != other.id_cliente)
		return false;
	

	
	if (data_ora == null) {
		if (other.data_ora != null)
			return false;
	} else if (!data_ora.equals(other.data_ora))
		return false;
	
	if (costo_tot==0.0) {
		if(other.costo_tot != 0.0 )
			return false;
	}else if(costo_tot != other.costo_tot)
		return false;
	
	return true;	
}
}
