package it.contrader.dto;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.contrader.model.Bevanda;
import it.contrader.model.Piatto;
import it.contrader.model.Prenotazione;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrdinazioneDTO {
	private long id;
	private float costo_tot;
	private Date data_ora;
	private Set<Piatto> piatto;
	private Set<Bevanda> bevanda;
	private Prenotazione prenotazione;
}
