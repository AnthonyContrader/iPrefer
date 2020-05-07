package it.contrader.model;
/**
 * Per dettagli vedi guida settimana 1 sez 4 Model
 */
public class Piatto {

	/**
	 * Qui sotto definisco gli attributi di Piatto. 
	 */
	private int  id_piatto;
	private String nome_piatto;
	private String ingredienti;
	private String descrizione_piatto;
	private float costo_piatto;

	/**
	 * Definisco i due costruttori, uno vuoto, uno con tutti i parametri meno l'id_piatto, e uno con tutti i parametri
	 */
	public Piatto() {
		
	}

	public Piatto (String nome_piatto, String ingredienti, float costo_piatto, String descrizione_piatto) {
		this.nome_piatto=nome_piatto;
		this.ingredienti=ingredienti;
		this.descrizione_piatto=descrizione_piatto;
		this.costo_piatto=costo_piatto;
	}

	public Piatto (int id_piatto, String nome_piatto, String ingredienti,float costo_piatto, String descrizione_piatto) {
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
		
		//Metodo per il confronto degli oggetti
		
		@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Piatto other = (Piatto) obj;
				if (id_piatto != other.id_piatto)
					return false;
				if (nome_piatto == null) {
					if (other.nome_piatto != null)
						return false;
				} else if (!nome_piatto.equals(other.nome_piatto))
					return false;
				if (ingredienti == null) {
					if (other.ingredienti != null)
						return false;
				} else if (!ingredienti.equals(other.ingredienti))
					return false;
				if (descrizione_piatto == null) {
					if (other.descrizione_piatto != null)
						return false;
				} else if (!descrizione_piatto.equals(other.descrizione_piatto))
					return false;
				if (costo_piatto == 0.0) {
					if (other.costo_piatto != 0.0)
						return false;
				} else if (costo_piatto != other.costo_piatto)
					return false;
				return true;
			}

	}
