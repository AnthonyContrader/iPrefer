package it.contrader.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PiattoDTO {

	private long id;

	private String nome_piatto;

	private String ingredienti;

	private float costo_piatto;
	
	private String descrizione_piatto;

}