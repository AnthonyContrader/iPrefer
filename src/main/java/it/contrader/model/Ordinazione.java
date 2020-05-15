package it.contrader.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Ordinazione_Piatto", joinColumns = {
			@JoinColumn(name = "id_ordinazione", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "id_piatto", referencedColumnName = "id"), })

	private Set<Piatto> piatto = new HashSet<Piatto>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Ordinazione_Bevanda", joinColumns = {
			@JoinColumn(name = "id_ordinazione", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "id_bevanda", referencedColumnName = "id") })

	private Set<Bevanda> bevanda = new HashSet<Bevanda>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Prenotazione prenotazione;

	@Column
	private float costo_tot;
	private Date data_ora;

}
