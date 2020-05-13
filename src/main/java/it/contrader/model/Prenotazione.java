package it.contrader.model;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



//@AllArgsConstructor
//@NoArgsConstructor
//@Data
@Entity
public class Prenotazione {
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	
	Date data_ora = new Date();
	DateFormat formatoData = DateFormat.getDateInstance(DateFormat.LONG, Locale.ITALY);
	
	private int tavolo;
	
	
//	@ManyToOne
//	@JoinColumn(name= "id_cliente", referencedColumnName="id_cliente")
//	private Cliente id_cliente;
	
}
