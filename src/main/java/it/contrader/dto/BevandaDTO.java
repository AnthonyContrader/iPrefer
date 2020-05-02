package it.contrader.dto;
/**
 * 
 * @author simone
 *
 */
public class BevandaDTO {
	/**
	 * definisco gli attributi di bevanda
	 */
		private int id_bevanda;
		private String nome_bevanda;
		private float costo_bevanda;
		private boolean alcolico;
		private String descrizione;
		/**
		 * definisco i costruttori
		 */
		public BevandaDTO()
		{
			
		}
		public BevandaDTO(String nome_bevanda, float costo_bevanda, boolean alcolico, String descrizione)
		{
			this.nome_bevanda=nome_bevanda;
			this.costo_bevanda=costo_bevanda;
			this.alcolico=alcolico;
			this.descrizione=descrizione;
		}
		public BevandaDTO(int id_bevanda,String nome_bevanda, float costo_bevanda, boolean alcolico, String descrizione)
		{
			this.id_bevanda=id_bevanda;
			this.nome_bevanda=nome_bevanda;
			this.costo_bevanda=costo_bevanda;
			this.alcolico=alcolico;
			this.descrizione=descrizione;
		}
		
		/**
		 * definisco i metodi Set e Get
		 */
		public int getId_Bevanda()
		{
			return this.id_bevanda;
		}
		public void setId_Bevanda(int id_bevanda)
		{
			this.id_bevanda=id_bevanda;
		}
		public String getNome_Bevanda()
		{
			return this.nome_bevanda;
		}
		public void setNome_Bevanda(String nome_bevanda)
		{
			this.nome_bevanda=nome_bevanda;
		}
		public float getCosto_Bevanda()
		{
			return this.costo_bevanda;
		}
		public void setCosto_Bevanda(float costo_bevanda)
		{
			this.costo_bevanda=costo_bevanda;	
		}
		public boolean getAlcolico()
		{
			return this.alcolico;
		}
		public void setAlcolico(boolean alcolico)
		{
			this.alcolico=alcolico;
		}
		public String getDescrizione()
		{
			return this.descrizione;
		}
		public void setDescrizione(String descrizione)
		{
			this.descrizione=descrizione;
		}
		//metodo che trasforma un oggetto in una stringa
		@Override
		public String toString()
		{
			return id_bevanda + "\t" + nome_bevanda + "\t\t" + costo_bevanda  + "\t\t" + alcolico  + "\t\t" + descrizione;
		}
}
