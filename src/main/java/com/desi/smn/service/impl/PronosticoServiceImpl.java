package com.desi.smn.service.impl;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.smn.model.Ciudad;
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

	@Override
	public Pronostico getById(Long id) {
		
		return pronosticoReporitory.findById(id).orElse(null);
	}
	
	@Override
	public void validarPronostico(Pronostico pronostico, Ciudad ciudad) throws Exception {
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		
		String fechaPronostico = format.format(pronostico.getFechaPronosticada());

		for (Pronostico p : ciudad.getPronostico()) {

			if (format.format(p.getFechaPronosticada()).equals(fechaPronostico)) {

				throw new Exception("Ya existe un pronostico para esa Fecha y Ciudad");
			}
		}
		
	}

}
