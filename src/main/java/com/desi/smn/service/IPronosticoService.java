package com.desi.smn.service;

import com.desi.smn.model.Ciudad;
import com.desi.smn.model.Pronostico;

public interface IPronosticoService {
	
	void guardar(Pronostico pronostico);
	Pronostico getById(Long id);
	
	void validarPronostico(Pronostico pronostico, Ciudad ciudad)throws Exception;

}
