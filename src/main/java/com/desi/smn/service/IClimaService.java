package com.desi.smn.service;

import com.desi.smn.model.Clima;

public interface IClimaService {
	
	void guardar(Clima clima);
	
	Clima getById(Long id);
}
