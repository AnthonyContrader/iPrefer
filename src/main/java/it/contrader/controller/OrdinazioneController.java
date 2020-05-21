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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ClienteDTO;
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

@RestController
@RequestMapping("/ordinazione")
@CrossOrigin(origins = "http://localhost:4200")
public class OrdinazioneController extends AbstractController <OrdinazioneDTO>{

	@Autowired
	private OrdinazioneService service;
	@Autowired
	private PiattoService servicepiatto;
	@Autowired
	private BevandaService servicebevanda;
	@Autowired
	private PrenotazioneService serviceprenotazione;


}
