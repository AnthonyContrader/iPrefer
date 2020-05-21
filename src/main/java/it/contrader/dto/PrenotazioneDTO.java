package it.contrader.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import it.contrader.model.Cliente;
import it.contrader.model.Recensione;
//import it.contrader.model.Recensione;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class PrenotazioneDTO {
	
	private long id;
	
	private Date data_ora;
	
	private int tavolo;
	
	private Recensione recensione;
	
	private ClienteDTO clienteDTO;

}
