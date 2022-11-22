package com.desi.smn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.smn.model.Ciudad;
import com.desi.smn.repository.ICiudadRepository;
import com.desi.smn.service.ICiudadService;

@Service
public class CiudadServiceImpl implements ICiudadService {

	
	@Autowired
	private ICiudadRepository ciudadRepository;

	@Override
	public void guardar(Ciudad ciudad) {
		ciudadRepository.save(ciudad);

	}

	@Override
	public List<Ciudad> getAll() {

		return ciudadRepository.findAll();
	}

	@Override
	public Ciudad getById(Long id) {

		return ciudadRepository.findById(id).orElse(null);
	}

}
