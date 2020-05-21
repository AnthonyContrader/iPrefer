package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.BevandaDTO;
import it.contrader.service.BevandaService;

@RestController
@RequestMapping("/bevanda")
@CrossOrigin(origins = "http://localhost:4200")
public class BevandaController extends AbstractController<BevandaDTO> {
	
	@Autowired
	private BevandaService service;

}
