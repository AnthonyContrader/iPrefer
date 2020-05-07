package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.ClienteDTO;
import it.contrader.service.Service;
import it.contrader.service.ClienteService;

public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ClienteServlet() {
		
	}
	
	public void updateList(HttpServletRequest request) {
		Service<ClienteDTO> service = new ClienteService();
		List<ClienteDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ClienteDTO> service = new ClienteService();
		String mode = request.getParameter("mode");
		ClienteDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "CLIENTELIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/cliente/clientemanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id_cliente"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/cliente/readcliente.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/cliente/updatecliente.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String nomeCliente = request.getParameter("nome_cliente");
			String cognomeCliente = request.getParameter("cognome_cliente");
			Boolean intolleranza = Boolean.parseBoolean(request.getParameter("intolleranza_bool"));
			String telefono = request.getParameter("telefono");
			String intollerante = request.getParameter("intollerante");
			dto = new ClienteDTO (nomeCliente,cognomeCliente,intolleranza,telefono,intollerante);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/cliente/clientemanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			nomeCliente = request.getParameter("nome_cliente");
			cognomeCliente = request.getParameter("cognome_cliente");
			intolleranza = Boolean.parseBoolean(request.getParameter("intolleranza_bool"));
			telefono = request.getParameter("telefono");
			intollerante = request.getParameter("intollerante");
			id = Integer.parseInt(request.getParameter("id_cliente"));
			dto = new ClienteDTO (id,nomeCliente, cognomeCliente, intolleranza, telefono, intollerante);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/cliente/clientemanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id_cliente"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/cliente/clientemanager.jsp").forward(request, response);
			break;
		}
	}
}
