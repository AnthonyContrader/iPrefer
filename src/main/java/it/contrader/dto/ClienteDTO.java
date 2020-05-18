package it.contrader.dto;


import it.contrader.model.Prenotazione;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
	
	private long id;
	private String nome_cliente;
	private String cognome_cliente;
	private boolean intolleranza_bool;
	private String telefono;
	private String intollerante;
	//private Prenotazione prenotazione;
	
}
