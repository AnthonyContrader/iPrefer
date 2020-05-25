package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.PiattoDTO;
import it.contrader.service.PiattoService;

@RestController
@RequestMapping("/piatto")
@CrossOrigin(origins = "http://localhost:4200")
public class PiattoController extends AbstractController <PiattoDTO> {

	@Autowired
	private PiattoService service;
}
