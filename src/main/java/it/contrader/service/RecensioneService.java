package it.contrader.service;

import java.util.List;
import it.contrader.converter.RecensioneConverter;
import it.contrader.dao.RecensioneDAO;
import it.contrader.dto.RecensioneDTO;

public class RecensioneService {

	private RecensioneDAO recensioneDAO;
	private RecensioneConverter recensioneConverter;

	public RecensioneService() {
		this.recensioneDAO = new RecensioneDAO();
		this.recensioneConverter = new RecensioneConverter();
	}

	public List<RecensioneDTO> getAll() {
		return recensioneConverter.toDTOList(recensioneDAO.getAll());
	}

	public RecensioneDTO read(int id_recensione) {
		return recensioneConverter.toDTO(recensioneDAO.read(id_recensione));
	}

	public boolean insert(RecensioneDTO dto) {
		return recensioneDAO.insert(recensioneConverter.toEntity(dto));
	}

	public boolean update(RecensioneDTO dto) {
		return recensioneDAO.update(recensioneConverter.toEntity(dto));
	}

	public boolean delete(int id_recensione) {
		return recensioneDAO.delete(id_recensione);
	}
}
