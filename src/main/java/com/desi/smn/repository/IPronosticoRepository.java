package com.desi.smn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desi.smn.model.Pronostico;

@Repository
public interface IPronosticoRepository extends JpaRepository<Pronostico, Long> {
	

}
