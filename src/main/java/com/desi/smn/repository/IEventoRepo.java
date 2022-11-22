package com.desi.smn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desi.smn.model.Evento;


@Repository
public interface IEventoRepo extends JpaRepository<Evento, Long> {
	
	
}
