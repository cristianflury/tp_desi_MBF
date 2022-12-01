package com.desi.smn.model;




import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pronostico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date fechaPronosticada;
	
	private Integer probabilidadLluvia;
	
	private Integer cantidadLluvia;
	
	private String descripcion;
	
	@ManyToOne
	private Ciudad ciudad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaPronosticada() {
		return fechaPronosticada;
	}

	public void setFechaPronosticada(Date fechaPronosticada) {
		this.fechaPronosticada = fechaPronosticada;
	}

	public Integer getProbabilidadLluvia() {
		return probabilidadLluvia;
	}

	public void setProbabilidadLluvia(Integer probabilidadLluvia) {
		this.probabilidadLluvia = probabilidadLluvia;
	}

	public Integer getCantidadLluvia() {
		return cantidadLluvia;
	}

	public void setCantidadLluvia(Integer cantidadLluvia) {
		this.cantidadLluvia = cantidadLluvia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	
	
	
	

}
