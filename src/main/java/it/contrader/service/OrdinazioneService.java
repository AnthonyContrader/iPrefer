package it.contrader.service;

import java.util.List;

import it.contrader.converter.OrdinazioneConverter;
import it.contrader.dao.OrdinazioneDAO;
import it.contrader.dto.OrdinazioneDTO;

public class OrdinazioneService {

	private OrdinazioneDAO ordinazioneDAO;
	private OrdinazioneConverter ordinazioneConverter;
	
	public OrdinazioneService() {
		this.ordinazioneDAO=new OrdinazioneDAO();
		this.ordinazioneConverter=new OrdinazioneConverter();
	}
	
	public List<OrdinazioneDTO> getAll(){
		return ordinazioneConverter.toDTOList(ordinazioneDAO.getALL());
		
	}
	
	public OrdinazioneDTO read(int id_ordinazione) {
	return ordinazioneConverter.toDTO(ordinazioneDAO.read(id_ordinazione));
	}
	
	public boolean insert(OrdinazioneDTO dto) {
		return ordinazioneDAO.insert(ordinazioneConverter.toEntity(dto));
	}
	
	public boolean update(OrdinazioneDTO dto) {
		return ordinazioneDAO.update(ordinazioneConverter.toEntity(dto));
	}


	public boolean delete(int id_ordinazione) {
		return ordinazioneDAO.delete(id_ordinazione);
	}
	

}
