package it.contrader.dto;

public class PiattoDTO {
	
	// Definisco gli attributi di Piatto
	
		private int  id_piatto;
		private String nome_piatto;
		private String ingredienti;
		private String descrizione_piatto;
		private float costo_piatto;

	// Definisco i costruttori: uno vuoto ed due parametrizzati
		
		public PiattoDTO() {
			
		}
		
		public PiattoDTO (String nome_piatto, String ingredienti, float costo_piatto,String descrizione_piatto) {
			this.nome_piatto=nome_piatto;
			this.ingredienti=ingredienti;
			this.descrizione_piatto=descrizione_piatto;
			this.costo_piatto=costo_piatto;
		}
		
		public PiattoDTO (int id_piatto, String nome_piatto, String ingredienti, float costo_piatto, String descrizione_piatto) {
			this.id_piatto=id_piatto;
			this.nome_piatto=nome_piatto;
			this.ingredienti=ingredienti;
			this.descrizione_piatto=descrizione_piatto;
			this.costo_piatto=costo_piatto;
		}
		
	//Getter e setter per recuperare gli attributi della classe piatto dalle altre classi
		
		public int getIdPiatto()
		{
			return this.id_piatto;
		}
		
		public String getNomePiatto() {
			
			return this.nome_piatto;
		}
		
		public String getIngredienti() {
			
			return this.ingredienti;
		}
		
		public String getDescrizionePiatto() {
			return this.descrizione_piatto;
		}
		
		public float getCostoPiatto() {
			
			return this.costo_piatto;
		}

		public void setIdPiatto(int id_piatto)
		{
			this.id_piatto=id_piatto;
		}
		public void setNomePiatto(String nome_piatto)
		{
			this.nome_piatto=nome_piatto;
		}
		
		public void setIngredienti(String ingredienti)
		{
			this.ingredienti=ingredienti;
		}
		public void setDescrizionePiatto(String descrizione_piatto)
		{
			this.descrizione_piatto=descrizione_piatto;
		}
		public void setCostoPiatto(float costo_piatto) {
			this.costo_piatto=costo_piatto;
			
		}
		
	//Trasforma un oggetto in una stringa
			
		@Override
			public String toString() {
				return  id_piatto + "\t"  + nome_piatto +"\t\t" +   ingredienti + "\t\t" + descrizione_piatto+ "\t\t" + costo_piatto;
			}


}
