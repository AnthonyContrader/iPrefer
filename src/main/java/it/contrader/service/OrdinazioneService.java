package it.contrader.service;

import it.contrader.converter.OrdinazioneConverter;
import it.contrader.dao.OrdinazioneDAO;
import it.contrader.dto.OrdinazioneDTO;
import it.contrader.model.Ordinazione;

public class OrdinazioneService extends AbstractService<Ordinazione,OrdinazioneDTO>{

		public OrdinazioneService() {
			this.dao = new OrdinazioneDAO();
			this.converter = new OrdinazioneConverter();
			
			
		}
}
