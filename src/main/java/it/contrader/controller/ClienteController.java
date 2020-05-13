package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.ClienteDTO;
import it.contrader.service.ClienteService;


@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "clienti";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") long id) {
		service.delete(id);
		setAll(request);
		return "clienti";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatecliente";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") long id, @RequestParam("nome_cliente") String nome_cliente,
			@RequestParam("cognome_cliente") String cognome_cliente, @RequestParam("intolleranza_bool") boolean intolleranza_bool, @RequestParam("telefono") String telefono, @RequestParam("intollerante") String intollerante) {

		ClienteDTO dto = new ClienteDTO();
		dto.setId(id);
		dto.setNome_cliente(nome_cliente);
		dto.setCognome_cliente(cognome_cliente);
		dto.setIntolleranza_bool(intolleranza_bool);
		dto.setTelefono(telefono);
		dto.setIntollerante(intollerante);
		service.update(dto);
		setAll(request);
		return "clienti";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("nome_cliente") String nome_cliente,
			@RequestParam("cognome_cliente") String cognome_cliente, @RequestParam("intolleranza_bool") boolean intolleranza_bool, String telefono, String intollerante) {
		ClienteDTO dto = new ClienteDTO();
		dto.setNome_cliente(nome_cliente);
		dto.setCognome_cliente(cognome_cliente);
		dto.setIntolleranza_bool(intolleranza_bool);
		dto.setTelefono(telefono);
		dto.setIntollerante(intollerante);
		service.insert(dto);
		setAll(request);
		return "clienti";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readuser";
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
	