package com.desi.smn.dto;

import java.util.List;

import com.desi.smn.model.Clima;
import com.desi.smn.model.Estado;

public class EstadoDTO {
	private Long id;
	private List<Clima> climas;
	private String estado;
	
	//Constructores
	public EstadoDTO() {
		super();
	}
	
	public EstadoDTO(Estado estado) {
		super();
		this.id = estado.getId();
		this.estado = estado.getEstado();
	}

	//Getter & Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Clima> getIdClima() {
		return climas;
	}

	public void setIdClima(List<Clima> climas) {
		this.climas = climas;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
