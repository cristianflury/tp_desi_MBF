package com.desi.smn.dto;

import java.util.List;

import com.desi.smn.model.Ciudad;
import com.desi.smn.model.Provincia;

public class ProvinciaDTO {
	
    private Long id;
	
	private String nombre;
	
	private List<Ciudad> ciudades;
	
	public ProvinciaDTO() {
		
	}
	
	public ProvinciaDTO(Provincia provincia) {
		this.id = provincia.getId();
		this.nombre = provincia.getNombre();
		this.ciudades = provincia.getCiudades();
	}
	
	public Provincia toModel() {
		Provincia provincia = new Provincia();
		
		provincia.setId(this.id);
		provincia.setNombre(this.nombre);
		provincia.setId(this.id);
		
		return provincia;
		
	}

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

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
	

}
