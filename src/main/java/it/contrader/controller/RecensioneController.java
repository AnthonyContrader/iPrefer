package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.PrenotazioneDTO;
import it.contrader.dto.RecensioneDTO;
import it.contrader.model.Prenotazione;
import it.contrader.service.PrenotazioneService;
import it.contrader.service.RecensioneService;

@Controller
@RequestMapping("/recensione")
public class RecensioneController {

	@Autowired
	private RecensioneService service;	
	
	@Autowired
	private PrenotazioneService servicep;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "recensioni";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") long id) {
		service.delete(id);
		setAll(request);
		return "recensioni";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updaterecensione";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") long id, @RequestParam("voto") int voto,
			@RequestParam("testo") String testo) {

		RecensioneDTO dto = new RecensioneDTO();
		dto.setId(id);
		dto.setVoto(voto);
		dto.setTesto(testo);
		service.update(dto);
		setAll(request);
		return "recensioni";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("voto") int voto, @RequestParam("IdPren") Prenotazione prenotazione,
			@RequestParam("testo") String testo) {
		
		RecensioneDTO dto = new RecensioneDTO();
		dto.setVoto(voto);
		dto.setTesto(testo);
		dto.setPrenotazione(prenotazione);
		service.insert(dto);
		setAll(request);
		return "recensioni";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readrecensione";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
		request.getSession().setAttribute("listp", servicep.getAll());
	}
}
