package com.desi.smn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.desi.smn.dto.PronosticoDTO;
import com.desi.smn.model.Ciudad;
import com.desi.smn.model.Pronostico;
import com.desi.smn.model.Provincia;
import com.desi.smn.service.ICiudadService;
import com.desi.smn.service.IPronosticoService;

@Controller
@RequestMapping("/pronostico")
public class PronosticoController {
	
	@Autowired
	private IPronosticoService pronosticoService;
	
	@Autowired
	private ICiudadService ciudadService;
	
	@RequestMapping(method = RequestMethod.POST)
	public String guardar(@ModelAttribute("pronosticoDTO")PronosticoDTO pronosticoDTO) {
		
		Pronostico pronostico = pronosticoDTO.toModel();
		
		pronostico.setCiudad(ciudadService.getById(pronosticoDTO.getIdCiudad()));
		
		pronosticoService.guardar(pronostico);
		
		return "redirect:/pronostico";
		
		
	}
	
	 @ModelAttribute("allCiudades")
	    public List<Ciudad> getAllCiudades() {
	        return ciudadService.getAll();
	    }
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String paginaPronostico(@ModelAttribute("pronosticoDTO")PronosticoDTO pronosticoDTO) {
		return "pronostico";
	}

}
