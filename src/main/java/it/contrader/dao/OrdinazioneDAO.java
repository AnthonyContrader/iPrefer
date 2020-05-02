package it.contrader.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Ordinazione;
public class OrdinazioneDAO {
	
	private final String QUERY_ALL = "SELECT * FROM ordinazione";
	private final String QUERY_CREATE="INSERT INTO ordinazione(id_piatto,id_bevanda,id_cliente,data_ora,costo_tot) VALUES(?,?,?,?,?)";
    private final String QUERY_READ ="SELECT * FROM ordinazione WHERE id_ordinazione=?";
    private final String QUERY_UPDATE="UPDATE ordinazione SET id_piatto=?,id_bevanda=?,id_cliente=?,data_ora=?,costo_tot=? WHERE id_ordinazione=?";
    private final String QUERY_DELETE="DELETE FROM ordinazione WHERE id_ordinazione=?";
    
    public OrdinazioneDAO(){}
    
    public List<Ordinazione> getALL(){
    	List<Ordinazione> ordinazioniList=new ArrayList<>();
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
    			
    			ordinazione=new Ordinazione(id_piatto,id_bevanda,id_cliente,data_ora,costo_tot);
    			ordinazione.setId_ordinazione(id_ordinazione);
    			ordinazioniList.add(ordinazione);
    		}
    		} catch(SQLException e) {
    			e.printStackTrace();
    		}
    		return ordinazioniList;	
    }
    
    public boolean insert(Ordinazione ordinazioneToInsert) {
    	Connection connection = ConnectionSingleton.getInstance();
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
    		preparedStatement.setInt(1, ordinazioneToInsert.getId_piatto());
    		preparedStatement.setInt(2,ordinazioneToInsert.getId_bevanda());
    		preparedStatement.setInt(3, ordinazioneToInsert.getId_cliente());
    		preparedStatement.setString(4,ordinazioneToInsert.getData_ora());
    		preparedStatement.setFloat(5, ordinazioneToInsert.getCosto_tot());
    		preparedStatement.execute();
    		return true;
    	} catch (SQLException e) {
    		return false;
    	} 	
    }
    
    public Ordinazione read(int id_ordinazione) {
    	Connection connection = ConnectionSingleton.getInstance();
    	
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
    		preparedStatement.setInt(1, id_ordinazione);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		
    		resultSet.next();
    		
    		int id_piatto,id_bevanda,id_cliente;
    		String data_ora;
    		float costo_tot;
    		
    		id_piatto=resultSet.getInt("id_piatto");
    		id_bevanda=resultSet.getInt("id_bevanda");
    		id_cliente=resultSet.getInt("id_cliente");
    		data_ora=resultSet.getString("data_ora");
    		costo_tot=resultSet.getFloat("costo_tot");
    		
    		Ordinazione ordinazione=new Ordinazione(id_piatto,id_bevanda,id_cliente,data_ora,costo_tot);
    		ordinazione.setId_ordinazione(resultSet.getInt("id_ordinazione"));
    		return ordinazione;	
    	} catch (SQLException e) {
    	
		return null;	
    }
    
 }
    
    public boolean update(Ordinazione ordinazioneToUpdate) {
    	Connection connection = ConnectionSingleton.getInstance();
    	
    	if(ordinazioneToUpdate.getId_ordinazione()==0)
    		return false;
    	
    	Ordinazione ordinazioneRead=read(ordinazioneToUpdate.getId_ordinazione());
    	if(!ordinazioneRead.equals(ordinazioneToUpdate)) {
    		try {
    			if(ordinazioneToUpdate.getId_piatto()==0) {
    				ordinazioneToUpdate.setId_piatto(ordinazioneRead.getId_piatto());
    			}
    			
    			if(ordinazioneToUpdate.getId_bevanda()==0) {
    				ordinazioneToUpdate.setId_bevanda(ordinazioneRead.getId_bevanda());
    			}
    			
    			if(ordinazioneToUpdate.getId_cliente()==0) {
    				ordinazioneToUpdate.setId_client(ordinazioneRead.getId_cliente());
    			
    			}
    			
    			if (ordinazioneToUpdate.getData_ora()== null || ordinazioneToUpdate.getData_ora().equals("")) {
					ordinazioneToUpdate.setData_ora(ordinazioneRead.getData_ora());
				}
    			
    			if(ordinazioneToUpdate.getCosto_tot()==0.0) {
    				ordinazioneToUpdate.setCosto_tot(ordinazioneRead.getCosto_tot());
    			}
    			
    			PreparedStatement preparedStatement=(PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
    			preparedStatement.setInt(1, ordinazioneToUpdate.getId_piatto());
    			preparedStatement.setInt(2, ordinazioneToUpdate.getId_bevanda());
    			preparedStatement.setInt(3, ordinazioneToUpdate.getId_cliente());
    			preparedStatement.setString(4, ordinazioneToUpdate.getData_ora());
    			preparedStatement.setFloat(5, ordinazioneToUpdate.getCosto_tot());
    			preparedStatement.setInt(6,ordinazioneToUpdate.getId_ordinazione());
    			int a=preparedStatement.executeUpdate();
    			if(a>0)
    				return true;
    			else
    				return false;
    		} catch (SQLException e) {
    			return false;
    		}
    		
    	}
		return false; 	
    }
    
    public boolean delete(int id_ordinazione) {
    	Connection connection= ConnectionSingleton.getInstance();
    	
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
    		preparedStatement.setInt(1, id_ordinazione);
    		int n=preparedStatement.executeUpdate();
    		if(n !=0)
    			return true;
    	}catch(SQLException e) {
    		}
    	return false;
    }
}
