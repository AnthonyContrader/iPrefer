package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Bevanda;

/**
 * 
 * @author simone
 *
 */
public class BevandaDAO implements DAO<Bevanda> {

	private final String QUERY_ALL ="SELECT *FROM bevanda";
	private final String QUERY_CREATE ="INSERT INTO bevanda(nome_bevanda,costo_bevanda,alcolico,descrizione) VALUES (?,?,?,?)";
	private final String QUERY_READ ="SELECT * FROM bevanda WHERE id_bevanda=?";
	private final String QUERY_UPDATE="UPDATE bevanda SET nome_bevanda=?, costo_bevanda=?, alcolico=?, descrizione=? WHERE id_bevanda=?";
	private final String QUERY_DELETE="DELETE FROM bevanda WHERE id_bevanda=?";
	
	public List<Bevanda> getAll(){
		List<Bevanda> bevandaList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Bevanda bevanda;
			while (resultSet.next()) {
				int id_bevanda = resultSet.getInt("id_bevanda");
				String nome_bevanda =resultSet.getString("nome_bevanda");
				float costo_bevanda =resultSet.getFloat("costo_bevanda");
				boolean alcolico = resultSet.getBoolean("alcolico");
				String descrizione = resultSet.getString("descrizione");
				bevanda = new Bevanda(nome_bevanda , costo_bevanda, alcolico, descrizione);
				bevanda.setId_Bevanda(id_bevanda);
				bevandaList.add(bevanda);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return bevandaList;
	}
	public boolean insert (Bevanda bevandaToInsert) {
	Connection connection=ConnectionSingleton.getInstance();
	try {
		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
		preparedStatement.setString(1,  bevandaToInsert.getNome_Bevanda());
		preparedStatement.setFloat(2, bevandaToInsert.getCosto_Bevanda());
		preparedStatement.setBoolean(3, bevandaToInsert.getAlcolico());
		preparedStatement.setString(4, bevandaToInsert.getDescrizione());
		preparedStatement.execute();
		return true;
	}catch (SQLException e) {
		return false;		
		}
	}
	public Bevanda read(int bevandaId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, bevandaId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String nome_bevanda;
			float costo_bevanda;
			Boolean alcolico;
			String descrizione;
			
			nome_bevanda= resultSet.getString("nome_bevanda");
			costo_bevanda=resultSet.getFloat("costo_bevanda");
			alcolico =resultSet.getBoolean("alcolico");
			descrizione = resultSet.getString("descrizione");
			Bevanda bevanda= new Bevanda(nome_bevanda, costo_bevanda,alcolico, descrizione);
			bevanda.setId_Bevanda(resultSet.getInt("id_bevanda"));
			
			return bevanda;
		}catch(SQLException e){
			return null;
		}
	}
	public boolean update(Bevanda bevandaToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		//check if id is present
		if (bevandaToUpdate.getId_Bevanda() == 0)
			return false;
		
		Bevanda bevandaRead = read(bevandaToUpdate.getId_Bevanda());
		if(!bevandaRead.equals(bevandaToUpdate)) {
			//Fill the bevandaToUpdate object
			try {
				if(bevandaToUpdate.getNome_Bevanda() == null || bevandaToUpdate.getNome_Bevanda().equals("")) {
					bevandaToUpdate.setNome_Bevanda(bevandaRead.getNome_Bevanda());
				}
				if (bevandaToUpdate.getCosto_Bevanda() == 0.0) {
				bevandaToUpdate.setCosto_Bevanda(bevandaRead.getCosto_Bevanda());
				}
				/*
				if(bevandaToUpdate.getAlcolico()==false) {
					bevandaToUpdate.setAlcolico(bevandaRead.getAlcolico());
				}
				*/
				if(bevandaToUpdate.getDescrizione()==null || bevandaToUpdate.getDescrizione().equals("")) {
					bevandaToUpdate.setDescrizione(bevandaRead.getDescrizione());
				}
				//Update bevanda
				PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1,bevandaToUpdate.getNome_Bevanda());
				preparedStatement.setFloat(2, bevandaToUpdate.getCosto_Bevanda());
				preparedStatement.setBoolean(3, bevandaToUpdate.getAlcolico());
				preparedStatement.setString(4, bevandaToUpdate.getDescrizione());
				preparedStatement.setInt(5, bevandaToUpdate.getId_Bevanda());
				int a = preparedStatement.executeUpdate();
				if(a>0)
					return true;
				else
					return false;
			}catch(SQLException e) {
				return false;
			}
		}
		return false;
	}
	public boolean delete(int id_bevanda) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id_bevanda);
			int n = preparedStatement.executeUpdate();
			if(n!= 0)
				return true;
		}catch (SQLException e) {
			
		}
		return false;
	}
}
