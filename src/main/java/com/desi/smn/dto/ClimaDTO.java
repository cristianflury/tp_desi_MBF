package com.desi.smn.dto;

import org.springframework.lang.NonNull;

//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.Size;

import com.desi.smn.model.Clima;

public class ClimaDTO {
	private Long id;
	@NonNull
	private Long idCiudad;
	private String estado;
//	@Min(value = 0, message = "El valor mínimo permitido es 0")
//	@Max(value = 100, message = "El valor máximo permitido es 100")
	private int temperatura;
//	@Size(min = 0, max = 100, message = "El valor debe estar entre 0 y 100 (incluidos)")
	private int porcentajeHumedad;

	public ClimaDTO() {
		super();
	}

	public ClimaDTO(Clima clima) {
		super();
		this.id = clima.getId();
		this.idCiudad = clima.getCiudad().getId();
		this.estado = clima.getEstado();
		this.temperatura = clima.getTemperatura();
		this.porcentajeHumedad = clima.getPorcentajeHumedad();
	}

	// toModel
	public Clima toModel() {
		Clima clima = new Clima();

		clima.setId(this.id);
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
