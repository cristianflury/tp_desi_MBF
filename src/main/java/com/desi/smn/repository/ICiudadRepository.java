package com.desi.smn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desi.smn.model.Ciudad;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Long> {

}
