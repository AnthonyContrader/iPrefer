package it.contrader.service;

import it.contrader.converter.RecensioneConverter;
import it.contrader.dao.RecensioneDAO;
import it.contrader.dto.RecensioneDTO;
import it.contrader.model.Recensione;

public class RecensioneService extends AbstractService<Recensione, RecensioneDTO> {

	public RecensioneService() {
		this.dao = new RecensioneDAO();
		this.converter = new RecensioneConverter();
	}

}
