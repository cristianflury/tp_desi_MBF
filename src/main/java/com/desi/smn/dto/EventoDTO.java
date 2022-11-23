package com.desi.smn.dto;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.desi.smn.model.Evento;


public class EventoDTO {
	
	private String descripcion;
	
	private Long idCiudad;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dia;

	public EventoDTO() {
		
	}

	public EventoDTO(Evento evento) {
		
		this.descripcion = evento.getDescripcion();
		this.idCiudad = evento.getCiudad().getId();
		this.dia = evento.getDia();
	}
	
	public Evento toModel() {
		
		Evento evento = new Evento();
		
		evento.setDescripcion(this.descripcion);
		evento.setDia(this.dia);
		
		return evento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}
	

}
