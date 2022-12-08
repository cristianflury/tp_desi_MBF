package com.desi.smn.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Ciudad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	@ManyToOne
	private Provincia provincia;
	
	@OneToMany(mappedBy = "ciudad")
	private List<Pronostico> pronostico;
	
	@OneToOne(mappedBy = "ciudad")
	private Clima clima; 
	
	@OneToMany(mappedBy = "ciudad")
	private List<Evento> evento;
	
	@OneToMany(mappedBy = "ciudad")
	private List<Subscripto> subscripto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Pronostico> getPronostico() {
		return pronostico;
	}

	public void setPronostico(List<Pronostico> pronostico) {
		this.pronostico = pronostico;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Clima getClima() {
		return clima;
	}

	public void setClima(Clima clima) {
		this.clima = clima;
	}

	public List<Evento> getEvento() {
		return evento;
	}

	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}
	
	
	
	
}
