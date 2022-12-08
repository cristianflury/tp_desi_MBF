package com.desi.smn.model;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Subscripto {
	
	@Id
	private int dni;
	
	private String nombre;
	
	private String email;
	
	@ManyToOne
	private Ciudad ciudad;

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

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public void setCiudad(Optional<Ciudad> findById) {
		
		
	}	
	

}
