package com.desi.smn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.desi.smn.dto.CiudadDTO;
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

	@RequestMapping( method = RequestMethod.POST)
	public String guardar(@ModelAttribute("pronosticoDTO") PronosticoDTO pronosticoDTO) {

		Pronostico pronostico = pronosticoDTO.toModel();

		pronostico.setCiudad(ciudadService.getById(pronosticoDTO.getIdCiudad()));

		pronosticoService.guardar(pronostico);

		return "redirect:/pronostico";

	}

	@ModelAttribute("allCiudades")
	public List<Ciudad> getAllCiudades() {
		return ciudadService.getAll();
	}

	@RequestMapping(path = "/agregar", method = RequestMethod.GET)
	public String paginaPronosticoAgregar(@ModelAttribute("pronosticoDTO") PronosticoDTO pronosticoDTO) {
		return "pronosticoAgregar";
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.GET)
	public String paginaPronosticoEditar(@ModelAttribute("pronosticoDTO") PronosticoDTO pronosticoDTO) {
		
		return "pronosticoEditar";
	}
	
	@RequestMapping(path = "/datos",method = RequestMethod.POST)
	public String paginaPronostico(Model model, CiudadDTO ciudadDTO) {
		
		Ciudad ciudad = ciudadService.getById(ciudadDTO.toModel().getId());
		
		CiudadDTO ciudadForm = new CiudadDTO(ciudad);
		List<Pronostico> pronosticos = ciudadForm.getPronostico();
		
		
		model.addAttribute("pronosticos", pronosticos);
		
		return "pronostico";
	}

	@RequestMapping(path = "/ciudadElegir", method = RequestMethod.GET)
	public String paginaCiudadElegir(@ModelAttribute("pronosticoDTO")PronosticoDTO pronosticoDTO) {
		return "ciudadElegir";
	}

}
