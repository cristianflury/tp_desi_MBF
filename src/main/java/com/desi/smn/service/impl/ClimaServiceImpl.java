package com.desi.smn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.smn.dto.ClimaDTO;
import com.desi.smn.model.Clima;
import com.desi.smn.repository.IClimaRepository;
import com.desi.smn.service.IClimaService;

@Service
public class ClimaServiceImpl implements IClimaService{

	@Autowired
	private IClimaRepository climaRepository; 
	
	@Override
	public void guardar(Clima clima) {
		climaRepository.save(clima);			
	}
	
	//FALTA BUSCAR !!!CIUDAD!!! POR getById(Long id) ID 
	
	@Override
	public Clima getById(Long id) {
		return climaRepository.findById(id).orElse(null);
	}

	@Override
	public Clima filter(ClimaDTO filter) {
		return climaRepository.findByIdCiudad(filter.getIdCiudad());
	}

	@Override
	public List<Clima> getAll() {
		return climaRepository.findAll();
	}
}
