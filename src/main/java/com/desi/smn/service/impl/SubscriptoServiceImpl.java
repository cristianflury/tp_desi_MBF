package com.desi.smn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.desi.smn.model.Subscripto;
import com.desi.smn.repository.ICiudadRepository;
import com.desi.smn.repository.ISubscriptoRepository;
import com.desi.smn.service.ISubscriptoService;

public class SubscriptoServiceImpl implements ISubscriptoService, ApplicationRunner {
	
	@Autowired(required=true)
	ISubscriptoRepository repo;
	
	@Autowired
	ICiudadRepository repoCiudad;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		cargarDatosSubs();
	}
	
	@Override
	public void save(Subscripto p) {
		repo.save(p);
	}
	
	@Override
	public List<Subscripto> getAll() {
		return repo.findAll();
	}

	@Override
	public Subscripto getByDni(int dni) {
		
		return repo.findByDni(dni);
	}
	
	
	
		private void cargarDatosSubs() {
			if(getByDni(34568745) == null) {
				
				Subscripto persona1 = new Subscripto();	
				persona1.setDni(34568745);
    		    persona1.setNombre("Roberto");
    		    persona1.setEmail("roberto@gmail.com");
    		    persona1.setCiudad(repoCiudad.findById((long)1));
				repo.save(persona1);
				}	
				
			if(getByDni(350024585) == null) {
				Subscripto persona2 = new Subscripto();	
				persona2.setDni(350024585);
    		    persona2.setNombre("Juan");
    		    persona2.setEmail("juan@gmail.com");
    		    persona2.setCiudad(repoCiudad.findById((long) 3));;
				repo.save(persona2);
				}	
				
			if(getByDni(350000585) == null) {
				Subscripto persona3 = new Subscripto();	
				persona3.setDni(350000585);
    		    persona3.setNombre("Pedro");
    		    persona3.setEmail("pedro@gmail.com");
    		    persona3.setCiudad(repoCiudad.findById((long) 3));;
				repo.save(persona3);
			}
		}
	
	

}
