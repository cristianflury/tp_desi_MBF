package com.desi.smn.service;

import java.util.List;

import com.desi.smn.model.Subscripto;

public interface ISubscriptoService {
	
	void save(Subscripto persona);
	Subscripto getByDni(int dni);
	List<Subscripto> getAll();
}
