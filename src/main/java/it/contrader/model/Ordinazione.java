package it.contrader.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Ordinazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToMany
	@JoinTable(name = "Ordinazione_Piatto", joinColumns = {
			@JoinColumn(name = "id_ordinazionepiatto", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "id_piatto", referencedColumnName = "id"), })

private Set<Piatto> piatto = new HashSet<Piatto>();
	

	@ManyToMany
	@JoinTable(name = "Ordinazione_Bevanda", joinColumns = {
			@JoinColumn(name = "id_ordinazionebevanda", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "id_bevanda", referencedColumnName = "id") })
	private Set<Bevanda> bevanda = new HashSet<Bevanda>();

	@OneToOne
	@JoinColumn
	private Prenotazione prenotazione;

	@Column
	private float costo_tot;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date data_ora;

}
