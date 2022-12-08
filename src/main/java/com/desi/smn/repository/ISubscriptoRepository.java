package com.desi.smn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desi.smn.model.Subscripto;

@Repository
public interface ISubscriptoRepository extends JpaRepository<Subscripto, Long>{
	
	@Query("SELECT p FROM Subscripto p WHERE p.dni =?1")
	Subscripto findByDni (int dni);

}
