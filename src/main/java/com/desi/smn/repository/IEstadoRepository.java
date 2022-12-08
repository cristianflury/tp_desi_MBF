package com.desi.smn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desi.smn.model.Estado;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado, Long>{
	@Query("SELECT e FROM Estado e WHERE e.estado like ?1")
	Estado findByEstado(String estado);
}
