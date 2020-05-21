package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ClienteDTO;
import it.contrader.dto.PrenotazioneDTO;
import it.contrader.dto.RecensioneDTO;
import it.contrader.model.Prenotazione;
import it.contrader.service.PrenotazioneService;
import it.contrader.service.RecensioneService;

@RestController
@RequestMapping("/recensione")
@CrossOrigin(origins = "http://localhost:4200")
public class RecensioneController extends AbstractController <RecensioneDTO> {

	@Autowired
	private RecensioneService service;	
	
	@Autowired
	private PrenotazioneService servicep;

	
}
