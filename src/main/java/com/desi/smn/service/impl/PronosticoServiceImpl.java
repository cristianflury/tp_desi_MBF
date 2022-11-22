package com.desi.smn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.smn.model.Pronostico;
import com.desi.smn.repository.IPronosticoRepository;
import com.desi.smn.service.IPronosticoService;

@Service
public class PronosticoServiceImpl implements IPronosticoService {
	
	@Autowired
	private IPronosticoRepository pronosticoReporitory;

	@Override
	public void guardar(Pronostico pronostico) {
		
		pronosticoReporitory.save(pronostico);
		
	}

}
