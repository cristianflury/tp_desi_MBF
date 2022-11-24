package com.desi.smn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desi.smn.model.Clima;

@Repository
public interface IClimaRepository extends JpaRepository<Clima, Long>{

}
