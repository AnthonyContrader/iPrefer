package it.contrader.service;

import it.contrader.converter.BevandaConverter;
import it.contrader.dao.BevandaDAO;
import it.contrader.dto.BevandaDTO;
import it.contrader.model.Bevanda;
/**
 * 
 * @author simone
 *
 */
public class BevandaService  extends AbstractService<Bevanda, BevandaDTO> {
	//istanzio DAO e Converter specifici
	public BevandaService() {
		this.dao = new BevandaDAO();
		this.converter = new BevandaConverter();
	}
}
