package com.desi.smn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.smn.model.Estado;
import com.desi.smn.repository.IEstadoRepository;
import com.desi.smn.service.IEstadoService;

@Service
public class EstadoServiceImpl implements IEstadoService{
	@Autowired
	private IEstadoRepository estadoRepository;
	
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
}
