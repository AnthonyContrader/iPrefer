package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Piatto {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) //GenerationType.IDENTITY)
	private long id;

	@Column(unique = true)
	
	private String nome_piatto;

	private String ingredienti;

	private float costo_piatto;
	
	private String descrizione_piatto;

}
