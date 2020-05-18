package it.contrader.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.OrdinazioneDTO;
import it.contrader.dto.PiattoDTO;
import it.contrader.model.Bevanda;
import it.contrader.model.Cliente;
import it.contrader.model.Piatto;
import it.contrader.model.Prenotazione;
import it.contrader.service.BevandaService;
import it.contrader.service.OrdinazioneService;
import it.contrader.service.PiattoService;
import it.contrader.service.PrenotazioneService;

@Controller
@RequestMapping("/ordinazione")
public class OrdinazioneController {

	@Autowired
	private OrdinazioneService service;
	@Autowired
	private PiattoService servicepiatto;
	@Autowired
	private BevandaService servicebevanda;
	@Autowired
	private PrenotazioneService serviceprenotazione;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "ordinazioni";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") long id) {

		service.delete(id);
		setAll(request);
		return "ordinazioni";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateordinazione";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request,@RequestParam("id") long id,@RequestParam("id_piatto") Set<Piatto> piatto,
			@RequestParam("id_bevanda") Set<Bevanda> bevanda,
			@RequestParam("id_prenotazione") Prenotazione prenotazione,@RequestParam("data_ora")  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date data_ora) {

		OrdinazioneDTO dto = new OrdinazioneDTO();
		float costo_tot = 0;


		for (Piatto p : piatto) {
			costo_tot += p.getCosto_piatto();
			
		}
		for (Bevanda b : bevanda) {
			costo_tot += b.getCosto_bevanda();
		}
		
		
		dto.setId(id);
		dto.setCosto_tot(costo_tot);
		dto.setData_ora(data_ora);
		dto.setBevanda(bevanda);
		dto.setPrenotazione(prenotazione);
		dto.setPiatto(piatto);
		service.update(dto);
		setAll(request);
		return "ordinazioni";
	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("id_piatto") Set<Piatto> piatto,
			@RequestParam("id_bevanda") Set<Bevanda> bevanda,
			@RequestParam("id_prenotazione") Prenotazione prenotazione,@RequestParam("data_ora")  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date data_ora) {
		OrdinazioneDTO dto = new OrdinazioneDTO();

		float costo_tot = 0;


		for (Piatto p : piatto) {
			costo_tot += p.getCosto_piatto();
			
		}
		for (Bevanda b : bevanda) {
			costo_tot += b.getCosto_bevanda();
		}
		
		

		dto.setCosto_tot(costo_tot);
		dto.setData_ora(data_ora);
		dto.setBevanda(bevanda);
		dto.setPrenotazione(prenotazione);
		dto.setPiatto(piatto);
		service.insert(dto);
		setAll(request);
		return "ordinazioni";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readordinazioni";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
		request.getSession().setAttribute("listpiatto", servicepiatto.getAll());
		request.getSession().setAttribute("listbevanda", servicebevanda.getAll());
		request.getSession().setAttribute("listprenotazione", serviceprenotazione.getAll());
	}
}
