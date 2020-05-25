package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.PrenotazioneDTO;
import it.contrader.service.PrenotazioneService;
import it.contrader.service.ClienteService;


@RestController
@RequestMapping("/prenotazione")
@CrossOrigin(origins = "http://localhost:4200")
public class PrenotazioneController extends AbstractController<PrenotazioneDTO> {
	
	@Autowired
	private PrenotazioneService service;
	
	@Autowired
	private ClienteService clienteService;
	
	
}
