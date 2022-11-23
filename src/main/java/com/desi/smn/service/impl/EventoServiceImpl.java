package com.desi.smn.service.impl;

import org.springframework.stereotype.Service;

import com.desi.smn.model.Evento;
import com.desi.smn.repository.IEventoRepository;
import com.desi.smn.service.IEventoService;

@Service
public class EventoServiceImpl implements IEventoService {

	IEventoRepository repo;
	
	@Override
	public Evento getById(Long idEvento) {
		return repo.findById(idEvento).get();
	}

	@Override
	public void save(Evento c) {
		repo.save(c);
		
	}
	

	@Override
	public Evento envioEmail() {
		// TODO Auto-generated method stub
		return null;
	}

}
