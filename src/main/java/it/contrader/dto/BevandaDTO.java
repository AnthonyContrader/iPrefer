package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BevandaDTO {
	
	private long id;
	private String nome_bevanda;
	private float costo_bevanda;
	private Boolean alcolico;
	private String descrizione;
}
