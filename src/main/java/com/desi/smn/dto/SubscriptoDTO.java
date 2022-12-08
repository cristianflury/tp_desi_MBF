package com.desi.smn.dto;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.desi.smn.model.Ciudad;
import com.desi.smn.model.Subscripto;

public class SubscriptoDTO {
	
	@Id
	private int dni;
	
	private String nombre;
	
	@Email
	private String email;
	
	@NotNull(message = "La ciudad no debe ser nulo")
	private Long idCiudad;

	public SubscriptoDTO() {
		
	}

	public SubscriptoDTO(Subscripto sub) {
		
		this.dni= sub.getDni();
		this.nombre= sub.getNombre();
		this.email= sub.getEmail();
		this.idCiudad= sub.getCiudad().getId();
	}
	
	public Subscripto toModel() {
		
		Subscripto sub = new Subscripto();
		
		sub.setDni(this.dni);
		sub.setNombre(this.nombre);
		sub.setEmail(this.email);
		
		return sub;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}

	

	
	
	
	

}
