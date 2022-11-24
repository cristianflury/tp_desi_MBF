package com.desi.smn.dto;

import java.util.List;

import com.desi.smn.model.Ciudad;
import com.desi.smn.model.Evento;
import com.desi.smn.model.Pronostico;

public class CiudadDTO {
	
    private String nombre;
	
	private Long idProvincia;
	
	private List<Pronostico> pronostico;

	private Long idClima; //PREGUNTAR SI VA ID O VA LA VARIABLE CLIMA DE TIPO CLIMA
	//ABAJO DEJE MÁS COMENTARIOS
	private List<Evento> evento;
	
	public CiudadDTO() {
		
	}

	public CiudadDTO(Ciudad ciudad) {
		
		this.nombre = ciudad.getNombre();
		this.idProvincia = ciudad.getProvincia().getId();
		this.pronostico = ciudad.getPronostico();
		this.idClima = ciudad.getClima().getId(); //PREGUNTAR SI VA ID O VA LA VARIABLE CLIMA DE TIPO CLIMA
		this.evento = ciudad.getEvento();
	}
	
	
	public Ciudad toModel() {
		
		Ciudad ciudad = new Ciudad();
		
		ciudad.setNombre(this.nombre);
		ciudad.setPronostico(this.pronostico);
		ciudad.setEvento(this.evento);
		
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

	//VERIFICAR ESTOS GET Y SET
	public Long getIdClima() {
		return idClima;
	}

	public void setIdClima(Long idClima) {
		this.idClima = idClima;
	}
	
	public List<Evento> getEvento() {
		return evento;
	}

	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}
	
	
	
	
	

}
