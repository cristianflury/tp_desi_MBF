package com.desi.smn.service;

import org.springframework.stereotype.Service;

import com.desi.smn.model.Evento;
import com.desi.smn.repository.IEventoRepo;

@Service
public class EventoServiceImpl implements EventoService {

	IEventoRepo repo;
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
