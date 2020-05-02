package it.contrader.service;

import java.util.List;
import it.contrader.converter.BevandaConverter;
import it.contrader.dao.BevandaDAO;
import it.contrader.dto.BevandaDTO;
/**
 * 
 * @author simone
 *
 */
public class BevandaService {

	private BevandaDAO bevandaDAO;
	private BevandaConverter bevandaConverter;
	
	//istanzio DAO e Converter specifici
	public BevandaService() {
		this.bevandaDAO = new BevandaDAO();
		this.bevandaConverter = new BevandaConverter();
	}
	
	public List<BevandaDTO> getAll() {
		//ottiene una lista di entità e le restituisce convertendole in DTO
		return bevandaConverter.toDTOList(bevandaDAO.getAll());
	}
	
	public BevandaDTO read(int id_bevanda) {
		//ottiene un'entita e la restituisce convertendola in DTO
		return bevandaConverter.toDTO(bevandaDAO.read(id_bevanda));
	}
	
	public boolean insert(BevandaDTO dto) {
		//Converte un DTO in entita e lo passa al DAO per l'inserimento
		return bevandaDAO.insert(bevandaConverter.toEntity(dto));
	}
	
	public boolean update(BevandaDTO dto) {
		//converte un bevandaDTO in entita e lo passa allo BevandaDAO per la modifica
		return bevandaDAO.update(bevandaConverter.toEntity(dto));
	}
	
	public boolean delete(int id_bevanda) {
		// metodo chiama direttamente il DAO
		return bevandaDAO.delete(id_bevanda);
	}
}
