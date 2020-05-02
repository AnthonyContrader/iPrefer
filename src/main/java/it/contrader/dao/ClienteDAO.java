package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Cliente;

public class ClienteDAO {
	private final String QUERY_ALL = "SELECT * FROM cliente";
	private final String QUERY_CREATE = "INSERT INTO cliente (nome_cliente, cognome_cliente, intolleranza_bool, telefono, intollerante) VALUES (?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM cliente WHERE id_cliente=?";
	private final String QUERY_UPDATE = "UPDATE cliente SET nome_cliente=?, cognome_cliente=?, intolleranza_bool=?, telefono=?, intollerante=? WHERE id_cliente=?";
	private final String QUERY_DELETE = "DELETE FROM cliente WHERE id_cliente=?";
	
	public ClienteDAO() {
		
	}
	
	public List<Cliente> getAll() {
		List<Cliente> clienteList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Cliente cliente;
			while (resultSet.next()) {
				int id = resultSet.getInt("id_cliente");
				String nomeCliente = resultSet.getString("nome_cliente");
				String cognomeCliente  = resultSet.getString("cognome_cliente");
				Boolean intolleranza  = resultSet.getBoolean("intolleranza_bool");
				String telefono = resultSet.getString("telefono");
				String intollerante = resultSet.getString("intollerante");
				cliente = new Cliente(nomeCliente, cognomeCliente, intolleranza, telefono, intollerante);
				cliente.setIdCliente(id);
				clienteList.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clienteList;
	}
	
	public boolean insert(Cliente clienteToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, clienteToInsert.getNomeCliente());
			preparedStatement.setString(2, clienteToInsert.getCognomeCliente());
			preparedStatement.setBoolean(3, clienteToInsert.getIntolleranza());
			preparedStatement.setString(4,  clienteToInsert.getTelefono());
			preparedStatement.setString(5, clienteToInsert.getIntollerante());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
	
	public Cliente read(int clienteId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, clienteId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String nomeCliente, cognomeCliente, telefono, intollerante;
			Boolean intolleranza;

			nomeCliente = resultSet.getString("nome_cliente");
			cognomeCliente = resultSet.getString("cognome_cliente");
			intolleranza = resultSet.getBoolean("intolleranza_bool");
			telefono = resultSet.getString("telefono");
			intollerante = resultSet.getString("intollerante");
			Cliente cliente = new Cliente(nomeCliente, cognomeCliente, intolleranza, telefono, intollerante);
			cliente.setIdCliente(resultSet.getInt("id_cliente"));

			return cliente;
		} catch (SQLException e) {
			return null;
		}

	}
	
	public boolean update(Cliente clienteToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (clienteToUpdate.getIdCliente() == 0)
			return false;

		Cliente clienteRead = read(clienteToUpdate.getIdCliente());
		if (!clienteRead.equals(clienteToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (clienteToUpdate.getNomeCliente() == null || clienteToUpdate.getNomeCliente().equals("")) {
					clienteToUpdate.setNomeCliente(clienteRead.getNomeCliente());
				}

				if (clienteToUpdate.getCognomeCliente() == null || clienteToUpdate.getCognomeCliente().equals("")) {
					clienteToUpdate.setCognomeCliente(clienteRead.getCognomeCliente());
				}

				if (clienteToUpdate.getTelefono() == null || clienteToUpdate.getTelefono().equals("")) {
					clienteToUpdate.setTelefono(clienteRead.getTelefono());
				}
				
				if(clienteToUpdate.getIntolleranza()== false) {
					clienteToUpdate.setIntolleranza(clienteRead.getIntolleranza());
				}
				
				if (clienteToUpdate.getIntollerante() == null || clienteToUpdate.getIntollerante().equals("")) {
					clienteToUpdate.setIntollerante(clienteRead. getIntollerante());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, clienteToUpdate.getNomeCliente());
				preparedStatement.setString(2, clienteToUpdate.getCognomeCliente());
				preparedStatement.setBoolean(3, clienteToUpdate.getIntolleranza());
				preparedStatement.setString(4, clienteToUpdate.getTelefono());
				preparedStatement.setString(5, clienteToUpdate.getIntollerante());
				preparedStatement.setInt(6, clienteToUpdate.getIdCliente());
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

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
}
