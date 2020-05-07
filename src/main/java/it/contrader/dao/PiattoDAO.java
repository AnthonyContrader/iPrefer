package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Piatto;

/**
 * 
 * @author Santo
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class PiattoDAO implements DAO <Piatto> {

	private final String QUERY_ALL = "SELECT * FROM piatto";
	private final String QUERY_CREATE = "INSERT INTO piatto (nome_piatto, ingredienti, costo_piatto,descrizione_piatto) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM piatto WHERE id_piatto=?";
	private final String QUERY_UPDATE = "UPDATE piatto SET nome_piatto=?, ingredienti=?, costo_piatto=?, descrizione_piatto=? WHERE id_piatto=?";
	private final String QUERY_DELETE = "DELETE FROM piatto WHERE id_piatto=?";

//costruttore della classe PiattoDao
	
	public PiattoDAO() {

	}

// Metodo per la selezione dei piatti, viene restituita un'arraylist di tipo piatto con tutti i piatti presenti in tabella
	public List<Piatto> getAll() {
		List<Piatto> piattoList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Piatto piatto;
			while (resultSet.next()) {
				int id_piatto = resultSet.getInt("id_piatto");
				String nome_piatto = resultSet.getString("nome_piatto");
				String ingredienti = resultSet.getString("ingredienti");
				float costo_piatto = resultSet.getFloat("costo_piatto");
				String descrizione_piatto = resultSet.getString("descrizione_piatto");
				piatto = new Piatto(id_piatto, nome_piatto, ingredienti, costo_piatto, descrizione_piatto);
				piattoList.add(piatto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return piattoList;
	}
// metodo per l'inserimento dei dati. Si prendono i dati dell'oggetto piatto passato e 
//vengono inseriti nel db. La connessione al db viene sempre fatta con connection singleton
//specificato nel package it.contrader.main
	public boolean insert(Piatto piattoDaInserire) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, piattoDaInserire.getNomePiatto());
			preparedStatement.setString(2, piattoDaInserire.getIngredienti());
			preparedStatement.setFloat(3, piattoDaInserire.getCostoPiatto());
			preparedStatement.setString(4, piattoDaInserire.getDescrizionePiatto());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

// metodo read che fa select * from table where id_piatto= ?

	public Piatto read(int id_piatto) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id_piatto);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String nome_piatto, ingredienti, descrizione_piatto;
			float costo_piatto;

			nome_piatto = resultSet.getString("nome_piatto");
			ingredienti = resultSet.getString("ingredienti");
			costo_piatto= resultSet.getFloat("costo_piatto");
			descrizione_piatto = resultSet.getString("descrizione_piatto");
			Piatto piatto = new Piatto(id_piatto, nome_piatto, ingredienti, costo_piatto, descrizione_piatto);
			
			//piatto.setIdPiatto(resultSet.getInt("id_piatto"));
			//non più necessario perchè inserito nel costruttore
			
			return piatto;
			
		} catch (SQLException e) {
			return null;
		}

	}

// metodo per la modifica di un piatto, restituisce true se la modifica è stata effettuata 
//false altrimenti.
	
	public boolean update(Piatto piattoPerModifica) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (piattoPerModifica.getIdPiatto() == 0)
			return false;
//lettura dell'id del piatto passato in ingresso al metodo
		Piatto letturaDelPiatto = read(piattoPerModifica.getIdPiatto());
		if (!letturaDelPiatto.equals(piattoPerModifica)) {
			try {
				// Inserisce l'oggetto piattodaModificare
				if (piattoPerModifica.getNomePiatto() == null || piattoPerModifica.getNomePiatto().equals("")) {
					piattoPerModifica.setNomePiatto(letturaDelPiatto.getNomePiatto());
				}

				if (piattoPerModifica.getIngredienti() == null || piattoPerModifica.getIngredienti().equals("")) {
					piattoPerModifica.setIngredienti(letturaDelPiatto.getIngredienti());
				}

				if (piattoPerModifica.getCostoPiatto() == 0) {
					piattoPerModifica.setCostoPiatto(letturaDelPiatto.getCostoPiatto());
				}

				// Modifica del piatto
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, piattoPerModifica.getNomePiatto());
				preparedStatement.setString(2, piattoPerModifica.getIngredienti());
				preparedStatement.setFloat(3, piattoPerModifica.getCostoPiatto());
				preparedStatement.setString(4, piattoPerModifica.getDescrizionePiatto());
				preparedStatement.setInt(5, piattoPerModifica.getIdPiatto());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int id_piatto) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id_piatto);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}

}
