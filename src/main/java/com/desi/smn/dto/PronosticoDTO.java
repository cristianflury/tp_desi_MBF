package com.desi.smn.dto;


import java.util.Date;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import com.desi.smn.model.Pronostico;

public class PronosticoDTO {
	
	private Long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future(message="La fecha debe ser futura")
	@NotNull
    private Date fechaPronosticada;
	
	@NotNull
	@PositiveOrZero(message = "El número ingresado no puede ser negativo")
	private Integer probabilidadLluvia;
	
	@NotNull
	@PositiveOrZero(message = "El número ingresado no puede ser negativo")
	private Integer cantidadLluvia;
	
	@NotNull
	@Size (min=15, max=500, message="La descripción tiene que tener entre 15 y 500 caracteres")
	private String descripcion;
	
	
	private Long idCiudad;
	
	public PronosticoDTO() {
		
	}
	public PronosticoDTO (Pronostico pronostico ) {
		
		this.id = pronostico.getId();
		this.fechaPronosticada = pronostico.getFechaPronosticada();
		this.cantidadLluvia = pronostico.getCantidadLluvia();
		this.probabilidadLluvia = pronostico.getProbabilidadLluvia();
		this.descripcion = pronostico.getDescripcion();
		this.idCiudad = pronostico.getCiudad().getId();
	}
	
	public Pronostico toModel() {
		
		Pronostico pronostico = new Pronostico();
		
		pronostico.setId(this.id);
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	

}
