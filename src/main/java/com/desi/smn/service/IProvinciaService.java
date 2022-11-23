package com.desi.smn.service;


import java.util.List;

import com.desi.smn.model.Provincia;

public interface IProvinciaService {
	
	void guardar(Provincia provincia);
	
	List<Provincia> getAll();
	
	Provincia getById(Long id) ;

}
