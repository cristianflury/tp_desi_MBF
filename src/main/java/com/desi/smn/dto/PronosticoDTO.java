package com.desi.smn.dto;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.desi.smn.model.Pronostico;

public class PronosticoDTO {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaPronosticada;
	
	private Integer probabilidadLluvia;
	
	private Integer cantidadLluvia;
	
	private String descripcion;
	
	private Long idCiudad;
	
	public PronosticoDTO() {
		
	}
	public PronosticoDTO (Pronostico pronostico ) {
		
		this.fechaPronosticada = pronostico.getFechaPronosticada();
		this.cantidadLluvia = pronostico.getCantidadLluvia();
		this.probabilidadLluvia = pronostico.getProbabilidadLluvia();
		this.descripcion = pronostico.getDescripcion();
		this.idCiudad = pronostico.getCiudad().getId();
	}
	
	public Pronostico toModel() {
		
		Pronostico pronostico = new Pronostico();
		
		pronostico.setCantidadLluvia(this.cantidadLluvia);
		pronostico.setFechaPronosticada(this.fechaPronosticada);
		pronostico.setProbabilidadLluvia(this.probabilidadLluvia);
		pronostico.setDescripcion(this.descripcion);
		
		return pronostico;
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

	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}
	
	

}
