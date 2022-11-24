package com.desi.smn.dto;

import com.desi.smn.model.Clima;

public class ClimaDTO {
	private Long idCiudad;
	private String estado;
	private int temperatura;
	private int porcentajeHumedad;

	public ClimaDTO() {
	}

	public ClimaDTO(Clima clima) {
		this.idCiudad = clima.getCiudad().getId();
		this.estado = clima.getEstado();
		this.temperatura = clima.getTemperatura();
		this.porcentajeHumedad = clima.getPorcentajeHumedad();
	}

	// toModel
	public Clima toModel() {
		Clima clima = new Clima();

		clima.setEstado(this.estado);
		clima.setTemperatura(this.temperatura);
		clima.setPorcentajeHumedad(this.porcentajeHumedad);

		return clima;
	}

	// Getter & Setter
	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public int getPorcentajeHumedad() {
		return porcentajeHumedad;
	}

	public void setPorcentajeHumedad(int porcentajeHumedad) {
		this.porcentajeHumedad = porcentajeHumedad;
	}

}
