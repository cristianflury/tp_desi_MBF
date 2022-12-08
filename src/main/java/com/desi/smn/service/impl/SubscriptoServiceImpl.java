package com.desi.smn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.desi.smn.model.Subscripto;
import com.desi.smn.repository.ICiudadRepository;
import com.desi.smn.repository.ISubscriptoRepository;
import com.desi.smn.service.ISubscriptoService;

@Service
public class SubscriptoServiceImpl implements ISubscriptoService {
	
	@Autowired(required=true)
	ISubscriptoRepository repo;
	
	@Autowired
	ICiudadRepository repoCiudad;
	
	
	@Override
	public void save(Subscripto p) {
		repo.save(p);
	}
	
	@Override
	public List<Subscripto> getAll() {
		return repo.findAll();
	}

	@Override
	public Subscripto getByDni(int dni) {
		
		return repo.findByDni(dni);
	}
		

}
