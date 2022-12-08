package com.desi.smn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.desi.smn.model.Estado;
import com.desi.smn.repository.IEstadoRepository;
import com.desi.smn.service.IEstadoService;

@Service
public class EstadoServiceImpl implements IEstadoService, ApplicationRunner{
	@Autowired
	private IEstadoRepository estadoRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		cargarDatos();
	}

	@Override
	public void guardar(Estado estado) {
		estadoRepository.save(estado);
	}

	@Override
	public List<Estado> getAll() {
		return estadoRepository.findAll();
	}

	@Override
	public Estado getById(Long id) {
		return estadoRepository.findById(id).orElse(null);
	}

	@Override
	public Estado getByEstado(String estado) {
		return estadoRepository.findByEstado(estado);
	}
	
	//Cargar datos (si no existen) apenas inicia la App
	private void cargarDatos() {
		if(getByEstado("Despejado") == null) {
			Estado estado = new Estado();	
			estado.setEstado("Despejado");
			estadoRepository.save(estado);		
		}
		if(getByEstado("Nublado") == null) {
			Estado estado = new Estado();	
			estado.setEstado("Nublado");
			estadoRepository.save(estado);		
		}
		if(getByEstado("Lluvioso") == null) {
			Estado estado = new Estado();	
			estado.setEstado("Lluvioso");
			estadoRepository.save(estado);		
		}
		if(getByEstado("Nevando") == null) {
			Estado estado = new Estado();	
			estado.setEstado("Nevando");
			estadoRepository.save(estado);
		}
	}
	
}
