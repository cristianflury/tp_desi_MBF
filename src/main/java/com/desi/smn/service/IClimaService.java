package com.desi.smn.service;

import java.util.List;

import com.desi.smn.dto.ClimaDTO;
import com.desi.smn.model.Clima;

public interface IClimaService {
	
	List<Clima> getAll();
	
	void guardar(Clima clima);
	
	Clima getById(Long id);
	
	Clima filter(ClimaDTO filter);
}
