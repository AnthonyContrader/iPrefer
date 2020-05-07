package it.contrader.servlets;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.OrdinazioneDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.OrdinazioneService;
import it.contrader.service.Service;

public class OrdinazioneServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public OrdinazioneServlet() {}
	
	public void updateList(HttpServletRequest request) {
		Service<OrdinazioneDTO> service=new OrdinazioneService();
		List<OrdinazioneDTO>listDTO=service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		Service<OrdinazioneDTO> service = new OrdinazioneService();
		String mode=request.getParameter("mode");
		OrdinazioneDTO dto;
		int id_ordinazione;
		boolean ans;
		
		switch(mode.toUpperCase()) {
		
		case "ORDINAZIONELIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/ordinazione/ordinazionemanager.jsp").forward(request, response);
			break;
			
		case "READ":
			id_ordinazione = Integer.parseInt(request.getParameter("id_ordinazione"));
			dto = service.read(id_ordinazione);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/ordinazione/readordinazione.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/ordinazione/updateordinazione.jsp").forward(request, response);
			break;
			
		case "INSERT":
			int id_piatto= Integer.parseInt(request.getParameter("id_piatto"));
			int id_bevanda= Integer.parseInt(request.getParameter("id_bevanda"));
			int id_cliente= Integer.parseInt(request.getParameter("id_cliente"));
			String data_ora = request.getParameter("data_ora").toString();
			float costo_tot= Float.parseFloat(request.getParameter("costo_tot"));
			dto = new OrdinazioneDTO (id_piatto,id_bevanda,id_cliente,data_ora,costo_tot);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/ordinazione/ordinazionemanager.jsp").forward(request, response);
			break;
		
		case "UPDATE":
			id_piatto = Integer.parseInt(request.getParameter("id_piatto"));
			id_bevanda = Integer.parseInt(request.getParameter("id_bevanda"));
			id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
			data_ora = request.getParameter("data_ora");
			costo_tot = Float.parseFloat(request.getParameter("costo_tot"));
			id_ordinazione = Integer.parseInt(request.getParameter("id_ordinazione"));
			dto = new OrdinazioneDTO (id_ordinazione,id_piatto,id_bevanda,id_cliente,data_ora,costo_tot);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/ordinazione/ordinazionemanager.jsp").forward(request, response);
			break;
			
		case "DELETE":
			id_ordinazione = Integer.parseInt(request.getParameter("id_ordinazione"));
			ans = service.delete(id_ordinazione);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/ordinazione/ordinazionemanager.jsp").forward(request, response);
			break;
			
		}
		
	}

}
