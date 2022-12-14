package com.desi.smn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desi.smn.model.Provincia;

@Repository
public interface IProvinciaRepository extends JpaRepository<Provincia, Long>{

}
