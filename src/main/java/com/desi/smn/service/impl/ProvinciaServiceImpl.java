package com.desi.smn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.smn.model.Provincia;
import com.desi.smn.repository.IProvinciaRepository;
import com.desi.smn.service.IProvinciaService;

@Service
public class ProvinciaServiceImpl implements IProvinciaService {
	
	@Autowired
	private IProvinciaRepository provinciaRepository;

	@Override
	public void guardar(Provincia provincia) {
		provinciaRepository.save(provincia);
		
	}

	@Override
	public List<Provincia> getAll() {
	
		return provinciaRepository.findAll();
	}

	@Override
	public Provincia getById(Long id) {
		
		return provinciaRepository.findById(id).orElse(null);
	}
	

}
