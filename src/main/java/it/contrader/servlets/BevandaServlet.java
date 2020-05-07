package it.contrader.servlets;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.BevandaDTO;
import it.contrader.service.Service;
import it.contrader.service.BevandaService;

public class BevandaServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public BevandaServlet() {
	}
	public void updateList(HttpServletRequest request) {
		Service<BevandaDTO> service = new BevandaService();
		List<BevandaDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<BevandaDTO> service = new BevandaService();
		String mode = request.getParameter("mode");
		BevandaDTO dto;
		int id_bevanda;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "BEVANDALIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/bevanda/bevandamanager.jsp").forward(request, response);
			break;

		case "READ":
			id_bevanda= Integer.parseInt(request.getParameter("id_bevanda"));
			dto = service.read(id_bevanda);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/bevanda/readbevanda.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/bevanda/updatebevanda.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String nome_bevanda = request.getParameter("nome_bevanda").toString();
			float costo_bevanda = Float.parseFloat(request.getParameter("costo_bevanda"));
			Boolean alcolico = Boolean.parseBoolean(request.getParameter("alcolico"));
			String descrizione = request.getParameter("descrizione").toString();

			dto = new BevandaDTO (nome_bevanda ,costo_bevanda, alcolico ,descrizione);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/bevanda/bevandamanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			nome_bevanda = request.getParameter("nome_bevanda");
			costo_bevanda = Float.parseFloat(request.getParameter("costo_bevanda"));
			alcolico = Boolean.parseBoolean(request.getParameter("alcolico"));
			descrizione =request.getParameter("descrizione");
			id_bevanda = Integer.parseInt(request.getParameter("id_bevanda"));
			dto = new BevandaDTO (id_bevanda,nome_bevanda, costo_bevanda, alcolico, descrizione);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/bevanda/bevandamanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id_bevanda = Integer.parseInt(request.getParameter("id_bevanda"));
			ans = service.delete(id_bevanda);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/bevanda/bevandamanager.jsp").forward(request, response);
			break;
		}
	}
}

