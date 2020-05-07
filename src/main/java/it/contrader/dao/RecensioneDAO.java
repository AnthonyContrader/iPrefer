package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Recensione;
import it.contrader.utils.ConnectionSingleton;

public class RecensioneDAO implements DAO<Recensione> {

	private final String QUERY_ALL = "SELECT * FROM recensione";
	private final String QUERY_CREATE = "INSERT INTO recensione (voto, id_ordinazione, testo) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM recensione WHERE id_recensione=?";
	private final String QUERY_UPDATE = "UPDATE recensione SET voto=?, id_ordinazione=?, testo=? WHERE id_recensione=?";
	private final String QUERY_DELETE = "DELETE FROM recensione WHERE id_recensione=?";

	public RecensioneDAO() {

	}

	public List<Recensione> getAll() {
		List<Recensione> recensioniList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Recensione recensione;
			while (resultSet.next()) {
				int id_recensione = resultSet.getInt("id_recensione");
				int voto = resultSet.getInt("voto");
				int id_ordinazione = resultSet.getInt("id_ordinazione");
				String testo = resultSet.getString("testo");
				recensione = new Recensione(voto, id_ordinazione, testo);
				recensione.setId_recensione(id_recensione);
				recensioniList.add(recensione);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recensioniList;
	}

	public boolean insert(Recensione recensioneToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, recensioneToInsert.getVoto());
			preparedStatement.setInt(2, recensioneToInsert.getId_ordinazione());
			preparedStatement.setString(3, recensioneToInsert.getTesto());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Recensione read(int recensioneId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, recensioneId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int voto, id_ordinazione;
			String testo;

			voto = resultSet.getInt("voto");
			id_ordinazione = resultSet.getInt("id_ordinazione");
			testo = resultSet.getString("testo");
			Recensione recensione = new Recensione(voto, id_ordinazione, testo);
			recensione.setId_recensione(resultSet.getInt("id_recensione"));

			return recensione;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Recensione recensioneToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (recensioneToUpdate.getId_recensione() == 0)
			return false;

		Recensione recensioneRead = read(recensioneToUpdate.getId_recensione());
		if (!recensioneRead.equals(recensioneToUpdate)) {
			try {
				// Fill the recensioneToUpdate object
				if (recensioneToUpdate.getVoto() == 0) {
					recensioneToUpdate.setVoto(recensioneRead.getVoto());
				}
				if (recensioneToUpdate.getId_ordinazione() == 0) {
					recensioneToUpdate.setId_ordinazione(recensioneRead.getId_ordinazione());
				}

				if (recensioneToUpdate.getTesto() == null || recensioneToUpdate.getTesto().equals("")) {
					recensioneToUpdate.setTesto(recensioneRead.getTesto());
				}

				// Update the recensione
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, recensioneToUpdate.getVoto());
				preparedStatement.setInt(2, recensioneToUpdate.getId_ordinazione());
				preparedStatement.setString(3, recensioneToUpdate.getTesto());
				preparedStatement.setInt(4, recensioneToUpdate.getId_recensione());
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

	public boolean delete(int id_recensione) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id_recensione);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}

}
