package it.contrader.dto;

import java.util.Date;
import it.contrader.model.Cliente;
import it.contrader.model.Recensione;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PrenotazioneDTO {
	
	private long id;
	
	private Date data_ora;
	
	private int tavolo;
	
	private Recensione recensione;
	
	private Cliente cliente;

}
