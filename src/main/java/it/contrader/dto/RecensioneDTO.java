package it.contrader.dto;

import it.contrader.model.Prenotazione;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecensioneDTO {

	private long id;
	private int voto;
	private String testo;
	private Prenotazione prenotazione;

}
