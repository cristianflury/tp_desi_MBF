package com.desi.smn.service;

import java.util.List;

import com.desi.smn.model.Estado;

public interface IEstadoService {
	List<Estado> getAll();
	void guardar(Estado estado);
	Estado getById(Long id);
	Estado getByEstado (String estado);
}
