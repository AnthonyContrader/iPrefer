package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Ordinazione;

public class OrdinazioneDAO implements DAO<Ordinazione>{
	
	private final String QUERY_ALL="SELECT * FROM ordinazione";
	private final String QUERY_CREATE="INSERT INTO ordinazione (id_piatto,id_bevanda,id_cliente,data_ora,costo_tot) VALUES(?,?,?,?,?)";
	private final String QUERY_READ="SELECT * FROM ordinazione WHERE id_ordinazione=?";
	private final String QUERY_UPDATE="UPDATE ordinazione SET id_piatto=?,id_bevanda=?,id_cliente=?,data_ora=?,costo_tot=? WHERE id_ordinazione=?";
	private final String QUERY_DELETE="DELETE FROM ordinazione WHERE id_ordinazione=?";
	
	public OrdinazioneDAO() {}
	
	public List<Ordinazione> getAll(){
		
		List<Ordinazione> ordinazioniList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Ordinazione ordinazione;
			
			while(resultSet.next()) {
				
				int id_ordinazione=resultSet.getInt("id_ordinazione");
				int id_piatto=resultSet.getInt("id_piatto");
				int id_bevanda=resultSet.getInt("id_bevanda");
				int id_cliente=resultSet.getInt("id_cliente");
				String data_ora=resultSet.getString("data_ora");
				float costo_tot=resultSet.getFloat("costo_tot");
				
				ordinazione = new Ordinazione(id_piatto,id_bevanda,id_cliente,data_ora,costo_tot);
				ordinazione.SetId_Ordinazione(id_ordinazione);
				ordinazioniList.add(ordinazione);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ordinazioniList;	
	}
	
	public boolean insert(Ordinazione ordinazioneToInsert ) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, ordinazioneToInsert.GetId_Piatto());
			preparedStatement.setInt(2, ordinazioneToInsert.GetId_Bevanda());
			preparedStatement.setInt(3, ordinazioneToInsert.GetId_Cliente());
			preparedStatement.setString(4, ordinazioneToInsert.GetData_ora());
			preparedStatement.setFloat(5, ordinazioneToInsert.GetCosto_tot());
			preparedStatement.execute();
			return true;
			
		}catch(SQLException e){
			return false;
		}
	}
	
	public Ordinazione read(int ordinazioneID) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, ordinazioneID);
			ResultSet resultSet=preparedStatement.executeQuery();
			resultSet.next();
			
			int id_piatto,id_bevanda,id_cliente;
			String data_ora;
			float costo_tot;
			
			id_piatto=resultSet.getInt("id_piatto");
			id_bevanda=resultSet.getInt("id_bevanda");
			id_cliente=resultSet.getInt("id_cliente");
			data_ora=resultSet.getString("data_ora");
			costo_tot=resultSet.getFloat("costo_tot");
			
			Ordinazione ordinazione = new Ordinazione(id_piatto,id_bevanda,id_cliente,data_ora,costo_tot);
			ordinazione.SetId_Ordinazione(resultSet.getInt("id_ordinazione"));
			return ordinazione;
			
			
			
		}catch(SQLException e) {
			return null;
		}
	}
	
	public boolean update(Ordinazione ordinazioneToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		if(ordinazioneToUpdate.GetId_Ordinazione() == 0)
			return false;
		
		Ordinazione ordinazioneRead = read(ordinazioneToUpdate.GetId_Ordinazione());
		if(!ordinazioneRead.equals(ordinazioneToUpdate)) {
			try {
				
				if(ordinazioneToUpdate.GetId_Piatto()==0) {
					ordinazioneToUpdate.SetId_Piatto(ordinazioneRead.GetId_Piatto());
				}
				
				if(ordinazioneToUpdate.GetId_Bevanda()==0) {
					ordinazioneToUpdate.SetId_Bevanda(ordinazioneRead.GetId_Bevanda());
				}
				
				if(ordinazioneToUpdate.GetId_Cliente()==0) {
					ordinazioneToUpdate.SetId_Cliente(ordinazioneRead.GetId_Cliente());
				}
				
				if(ordinazioneToUpdate.GetData_ora()==null || ordinazioneToUpdate.GetData_ora().equals("")) {
					ordinazioneToUpdate.SetData_ora(ordinazioneRead.GetData_ora());
				}
				
				if(ordinazioneToUpdate.GetCosto_tot()==0.0) {
					ordinazioneToUpdate.SetCosto_tot(ordinazioneRead.GetCosto_tot());
				}
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1,ordinazioneToUpdate.GetId_Piatto());
				preparedStatement.setInt(2,ordinazioneToUpdate.GetId_Bevanda());
				preparedStatement.setInt(3,ordinazioneToUpdate.GetId_Cliente());
				preparedStatement.setString(4,ordinazioneToUpdate.GetData_ora());
				preparedStatement.setFloat(5,ordinazioneToUpdate.GetCosto_tot());
				preparedStatement.setInt(6,ordinazioneToUpdate.GetId_Ordinazione());
				int a=preparedStatement.executeUpdate();
				if(a > 0)
					return true;
					else
					return false;	
				
			}catch(SQLException e) {
				return false;
			}
		}
		return false;
	}
	
	public boolean delete(int id_ordinazione) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1,id_ordinazione);
			int n=preparedStatement.executeUpdate();
			if(n!=0)
				return true;
		}catch(SQLException e) {
		}
		return false;
	}
}
