package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.PrenotazioneDTO;
import it.contrader.service.Service;
import it.contrader.service.PrenotazioneService;

public class PrenotazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public PrenotazioneServlet() {
		
	}
	
	public void updateList(HttpServletRequest request) {
		Service<PrenotazioneDTO> service = new PrenotazioneService();
		List<PrenotazioneDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
		}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<PrenotazioneDTO> service = new PrenotazioneService();
		String mode = request.getParameter("mode");
		PrenotazioneDTO dto;
		int id_prenotazione;
		boolean ans;
		
		switch(mode.toUpperCase()) {
		
		case "PRENOTAZIONELIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/prenotazione/prenotazionemanager.jsp").forward(request, response);
			break;
		
		case "READ":
			id_prenotazione = Integer.parseInt(request.getParameter("id_prenotazione"));
			dto = service.read(id_prenotazione);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/prenotazione/readprenotazione.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/prenotazione/updateprenotazione.jsp").forward(request, response);
			
			break;
			
		case "INSERT":
			String data_ora = request.getParameter("data_ora").toString();
			int tavolo = Integer.parseInt(request.getParameter("tavolo"));
			int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
			dto = new PrenotazioneDTO (data_ora, tavolo, id_cliente);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/prenotazione/prenotazionemanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			data_ora = request.getParameter("data_ora");
			tavolo = Integer.parseInt(request.getParameter("tavolo"));
			id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
			id_prenotazione = Integer.parseInt(request.getParameter("id_prenotazione"));
			dto = new PrenotazioneDTO (id_prenotazione, data_ora, tavolo, id_cliente);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/prenotazione/prenotazionemanager.jsp").forward(request, response);
			break;
			
		case "DELETE":
			id_prenotazione = Integer.parseInt(request.getParameter("id_prenotazione"));
			ans = service.delete(id_prenotazione);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/prenotazione/prenotazionemanager.jsp").forward(request, response);
			break;
			
		}
	}
}
