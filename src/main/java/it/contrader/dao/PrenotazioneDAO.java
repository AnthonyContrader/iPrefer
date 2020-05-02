package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Prenotazione;

	//@author Samuel

public class PrenotazioneDAO {

	private final String QUERY_ALL = "SELECT * from prenotazione";
	private final String QUERY_CREATE = "INSERT INTO prenotazione (data_ora, tavolo, id_cliente) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM prenotazione WHERE id_prenotazione=?";
	private final String QUERY_UPDATE = "UPDATE prenotazione SET data_ora=?, tavolo=?, id_cliente=? WHERE id_prenotazione=?";
	private final String QUERY_DELETE = "DELETE FROM prenotazione WHERE id_prenotazione=?";
	
	public PrenotazioneDAO() {
		
	}
	
	public List<Prenotazione> getAll(){
		List<Prenotazione> prenotazioniList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Prenotazione prenotazione;
			while (resultSet.next()) {
				int id_prenotazione = resultSet.getInt("id_prenotazione");
				String data_ora = resultSet.getString("data_ora");
				int tavolo = resultSet.getInt("tavolo");
				int id_cliente = resultSet.getInt("id_cliente");
				prenotazione = new Prenotazione(id_prenotazione, data_ora, tavolo, id_cliente);
				prenotazione.setId_prenotazione(id_prenotazione);
				prenotazioniList.add(prenotazione);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prenotazioniList;
	}
	
	public boolean insert(Prenotazione prenotazioneToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, prenotazioneToInsert.getData_ora());
			preparedStatement.setInt(2, prenotazioneToInsert.getTavolo());
			preparedStatement.setInt(3, prenotazioneToInsert.getId_cliente());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}
	
	public Prenotazione read(int prenotazioneId_prenotazione) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, prenotazioneId_prenotazione);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int tavolo, id_cliente;
			String data_ora;
			
			data_ora = resultSet.getString("data_ora");
			tavolo = resultSet.getInt("tavolo");
			id_cliente = resultSet.getInt("id_cliente");
			Prenotazione prenotazione = new Prenotazione(data_ora, tavolo, id_cliente);
			prenotazione.setId_prenotazione(resultSet.getInt("id_prenotazione"));
			
			return prenotazione;
		} catch (SQLException e) {
			return null;
		}
		
	}
	
	public boolean update(Prenotazione prenotazioneToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		if (prenotazioneToUpdate.getId_prenotazione() == 0)
			return false;
		
		Prenotazione prenotazioneRead = read(prenotazioneToUpdate.getId_prenotazione());
		if (!prenotazioneRead.equals(prenotazioneToUpdate)) {
			try {
				
				if (prenotazioneToUpdate.getData_ora() == null || prenotazioneToUpdate.getData_ora().equals("")) {
					prenotazioneToUpdate.setData_ora(prenotazioneRead.getData_ora());
				}
				
				if (prenotazioneToUpdate.getTavolo() == 0) {
					prenotazioneToUpdate.setTavolo(prenotazioneRead.getTavolo());
				}
				
				if (prenotazioneToUpdate.getId_cliente() == 0) {
					prenotazioneToUpdate.setId_cliente(prenotazioneRead.getId_cliente());
				}
				
				//Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, prenotazioneToUpdate.getData_ora());
				preparedStatement.setInt(2, prenotazioneToUpdate.getTavolo());
				preparedStatement.setInt(3, prenotazioneToUpdate.getId_cliente());
				preparedStatement.setInt(4, prenotazioneToUpdate.getId_prenotazione());
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
	
	public boolean delete (int id_prenotazione) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id_prenotazione);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
			
		} catch (SQLException e) {
	    }
		return false;	
	}
	
	
}
