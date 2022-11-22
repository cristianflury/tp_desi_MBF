package com.desi.smn.service;

import java.util.List;

import com.desi.smn.model.Ciudad;

public interface ICiudadService {
	
	void guardar(Ciudad ciudad);

    List<Ciudad> getAll();

	Ciudad getById(Long id) ;

}
