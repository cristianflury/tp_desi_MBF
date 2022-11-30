package com.desi.smn.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desi.smn.model.Clima;

@Repository
public interface IClimaRepository extends JpaRepository<Clima, Long>{
	
	@Query("SELECT c FROM Clima c WHERE c.ciudad.id like ?1")
	Clima findByIdCiudad(Long idCiudad);
}
