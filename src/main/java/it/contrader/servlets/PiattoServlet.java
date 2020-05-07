package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.PiattoDTO;
import it.contrader.service.Service;
import it.contrader.service.PiattoService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class PiattoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PiattoServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<PiattoDTO> service = new PiattoService();
		List<PiattoDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<PiattoDTO> service = new PiattoService();
		String mode = request.getParameter("mode");
		PiattoDTO dto;
		int id_piatto;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "PIATTOLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/piatto/piattomanager.jsp").forward(request, response);
			break;

		case "READ":
			id_piatto = Integer.parseInt(request.getParameter("id_piatto"));
			dto = service.read(id_piatto);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/piatto/readpiatto.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/piatto/updatepiatto.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String nome_piatto = request.getParameter("nome_piatto").toString();
			String ingredienti = request.getParameter("ingredienti").toString();
			Float costo_piatto = Float.parseFloat(request.getParameter("costo_piatto").toString());
			String descrizione_piatto = request.getParameter("descrizione_piatto").toString();
			dto = new PiattoDTO (nome_piatto,ingredienti,costo_piatto,descrizione_piatto);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/piatto/piattomanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			nome_piatto = request.getParameter("nome_piatto");
			ingredienti = request.getParameter("ingredienti");
			costo_piatto = Float.parseFloat(request.getParameter("costo_piatto"));
			descrizione_piatto=request.getParameter("descrizione_piatto");
			id_piatto = Integer.parseInt(request.getParameter("id_piatto"));
			dto = new PiattoDTO (id_piatto,nome_piatto, ingredienti, costo_piatto, descrizione_piatto);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/piatto/piattomanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id_piatto = Integer.parseInt(request.getParameter("id_piatto"));
			ans = service.delete(id_piatto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/piatto/piattomanager.jsp").forward(request, response);
			break;
		}
	}
}