package it.contrader.servlets;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.RecensioneDTO;
import it.contrader.service.Service;
import it.contrader.service.RecensioneService;

public class RecensioneServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public RecensioneServlet() {
	}

	public void updateList(HttpServletRequest request) {
		Service<RecensioneDTO> service = new RecensioneService();
		List<RecensioneDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<RecensioneDTO> service = new RecensioneService();
		String mode = request.getParameter("mode");
		RecensioneDTO dto;
		int id_recensione;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "RECENSIONELIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/recensione/recensionemanager.jsp").forward(request, response); 
																										
			break;

		case "READ":
			id_recensione = Integer.parseInt(request.getParameter("id_recensione"));
			dto = service.read(id_recensione);
			request.setAttribute("dto", dto);

			if (request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/recensione/readrecensione.jsp").forward(request, response);

			}

			else
				getServletContext().getRequestDispatcher("/recensione/updaterecensione.jsp").forward(request, response);

			break;

		case "INSERT":
			int voto = Integer.parseInt(request.getParameter("voto"));
			int id_ordinazione = Integer.parseInt(request.getParameter("id_ordinazione"));
			String testo = request.getParameter("testo").toString();
			dto = new RecensioneDTO(voto, id_ordinazione, testo);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/recensione/recensionemanager.jsp").forward(request, response); 
																										
			break;

		case "UPDATE":
			voto = Integer.parseInt(request.getParameter("voto"));
			id_ordinazione = Integer.parseInt(request.getParameter("id_ordinazione"));
			testo = request.getParameter("testo");
			id_recensione = Integer.parseInt(request.getParameter("id_recensione"));
			dto = new RecensioneDTO(id_recensione, voto, id_ordinazione, testo);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/recensione/recensionemanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id_recensione = Integer.parseInt(request.getParameter("id_recensione"));
			ans = service.delete(id_recensione);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/recensione/recensionemanager.jsp").forward(request, response);
			break;
		}
	}
}
