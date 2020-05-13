package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.BevandaDTO;
import it.contrader.service.BevandaService;

@Controller
@RequestMapping("/bevanda")
public class BevandaController {
	
	@Autowired
	private BevandaService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return"bevande";
	}
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") long id) {
		service.delete(id);
		setAll(request);
		return "bevande";
	}
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatebevanda";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id")long id, @RequestParam("nome_bevanda") String nome_bevanda, @RequestParam("costo_bevanda")float costo_bevanda, @RequestParam("alcolico") boolean alcolico, @RequestParam("descrizione")String descrizione) {
		
		BevandaDTO dto = new BevandaDTO();
		dto.setId(id);
		dto.setNome_bevanda(nome_bevanda);
		dto.setCosto_bevanda(costo_bevanda);
		dto.setAlcolico(alcolico);
		dto.setDescrizione(descrizione);
		service.update(dto);
		setAll(request);
		return "bevande";
		
	}
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("nome_bevanda") String nome_bevanda, @RequestParam("costo_bevanda")float costo_bevanda, @RequestParam("alcolico") boolean alcolico, @RequestParam("descrizione")String descrizione) {
		
		BevandaDTO dto=new BevandaDTO();
		dto.setNome_bevanda(nome_bevanda);
		dto.setCosto_bevanda(costo_bevanda);
		dto.setAlcolico(alcolico);
		dto.setDescrizione(descrizione);
		service.insert(dto);
		setAll(request);
		return"bevande";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readbevanda";
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
