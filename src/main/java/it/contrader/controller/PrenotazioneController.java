package it.contrader.controller;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.PrenotazioneDTO;
import it.contrader.service.PrenotazioneService;

@Controller
@RequestMapping("/prenotazione")

public class PrenotazioneController {
	
	@Autowired
	private PrenotazioneService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "prenotazioni";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") long id) {
		service.delete(id);
		setAll(request);
		return "prenotazioni";
	}
	
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateprenotazione";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") long id, 
			@RequestParam("data_ora") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date data_ora, @RequestParam("tavolo") int tavolo) {
		
		PrenotazioneDTO dto = new PrenotazioneDTO();
		dto.setId(id);
		dto.setData_ora(data_ora);
		dto.setTavolo(tavolo);
		
		service.update(dto);
		setAll(request);
		return "prenotazioni";
		
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("data_ora") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date data_ora, @RequestParam("tavolo") int tavolo) {
		PrenotazioneDTO dto = new PrenotazioneDTO();
		dto.setData_ora(data_ora);
		dto.setTavolo(tavolo);
		
		service.insert(dto);
		setAll(request);
		return"prenotazioni";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto",service.read(id));	
		return "readprenotazione";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}	
}
