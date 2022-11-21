package com.desi.smn.dto;

import java.util.List;


import com.desi.smn.model.Ciudad;
import com.desi.smn.model.Pronostico;
import com.desi.smn.model.Provincia;

public class CiudadDTO {
	
    private String nombre;
	
	private Long idProvincia;
	
	private List<Pronostico> pronostico;
	
	public CiudadDTO() {
		
	}

	public CiudadDTO(Ciudad ciudad) {
		
		this.nombre = ciudad.getNombre();
		this.idProvincia = ciudad.getProvincia().getId();
		this.pronostico = ciudad.getPronostico();
	}
	
	
	public Ciudad toModel() {
		
		Ciudad ciudad = new Ciudad();
		
		ciudad.setNombre(this.nombre);
		ciudad.setPronostico(this.pronostico);
		
		return ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}

	public List<Pronostico> getPronostico() {
		return pronostico;
	}

	public void setPronostico(List<Pronostico> pronostico) {
		this.pronostico = pronostico;
	}
	
	
	
	
	

}
