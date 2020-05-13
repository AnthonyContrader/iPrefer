package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.PiattoDTO;
//import it.contrader.model.User.Usertype;
import it.contrader.service.PiattoService;

@Controller
@RequestMapping("/piatto")
public class PiattoController {

	@Autowired
	private PiattoService service;
/*
	@PostMapping("/login")
	public String login(HttpServletRequest request, @RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password) {

		UserDTO userDTO = service.findByUsernameAndPassword(username, password);
		request.getSession().setAttribute("user", userDTO);

		switch (userDTO.getUsertype()) {

		case ADMIN:
			return "homeadmin";

		case USER:
			return "index";

		default:
			return "index";
		}
	}
*/
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "piatti";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "piatti";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatepiatto";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") long id, @RequestParam("nome_piatto") String nome_piatto,
			@RequestParam("ingredienti") String ingredienti, @RequestParam("costo_piatto") float costo_piatto, @RequestParam("descrizione_piatto") String descrizione_piatto ) {

		PiattoDTO dto = new PiattoDTO();
		dto.setId(id);
		dto.setNome_piatto(nome_piatto);
		dto.setIngredienti(ingredienti);
		dto.setCosto_piatto(costo_piatto);
		dto.setDescrizione_piatto(descrizione_piatto);
		service.update(dto);
		setAll(request);
		return "piatti";

	}
	/*@RequestParam("id") long id,*/
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("nome_piatto") String nome_piatto, @RequestParam("ingredienti") String ingredienti, @RequestParam("costo_piatto") float costo_piatto, @RequestParam("descrizione_piatto") String descrizione_piatto) {
		PiattoDTO dto = new PiattoDTO();
		//dto.setId(id);
		dto.setNome_piatto(nome_piatto);
		dto.setIngredienti(ingredienti);
		dto.setCosto_piatto(costo_piatto);
		dto.setDescrizione_piatto(descrizione_piatto);
		service.insert(dto);
		setAll(request);
		return "piatti";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readpiatto";
	}

/*	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
*/
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
