package com.desi.smn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.desi.smn.dto.ClimaDTO;
import com.desi.smn.model.Clima;
import com.desi.smn.service.ICiudadService;
import com.desi.smn.service.IClimaService;

@Controller
@RequestMapping("/clima")
public class ClimaController {
	
	@Autowired(required = false)
	private IClimaService climaService;
	
	@Autowired
	private ICiudadService ciudadService;

	@RequestMapping(method = RequestMethod.POST)
	public String guardar(@ModelAttribute("climaDTO") ClimaDTO climaDTO) {
		Clima clima = climaDTO.toModel();

		clima.setCiudad(ciudadService.getById(climaDTO.getIdCiudad()));
		climaService.guardar(clima);

		return "redirect:/clima";
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public String paginaClima(@ModelAttribute("climaDTO") ClimaDTO climaDTO) {
		return "clima";
	}
}
