package com.desi.smn.controller;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.desi.smn.model.Evento;

/**
 * Objeto para insertar Evento, no editable.
 * @author Esteban
 *
 */

public class EventoForm {
	
	
	private Long id;
	
	@NotNull
	@Size(min=2, max=500)
	private String descripcion;
	
	@NotNull
	private long idCiudad;
	
	@NotNull
	private Date dia;

	public EventoForm() {
		super();
	}
	
	public EventoForm(Evento c) {
		super();
		this.id=c.getId();
		this.descripcion=c.getDescripcion();
		this.idCiudad=c.getCiudad().getId();
		this.dia=c.getDia();
	}

//	public EventoForm(Long id, @NotNull @Size(min = 2, max = 500) String descripcion, //@NotNull Ciudad ciudad,
//			@NotNull Date dia) {
//		super();
//		this.id = id;
//		this.descripcion = descripcion;
//		this.ciudad = ciudad;
//		this.dia = dia;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}
	
	public Evento toPojo()
	{
		Evento r = new Evento();
		r.setId(this.id);
		r.setDescripcion(this.getDescripcion());
		r.setDia(this.getDia());
		return r;
	}

	public long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(long idCiudad) {
		this.idCiudad = idCiudad;
	}
	

}
