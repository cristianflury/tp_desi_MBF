package com.desi.smn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.desi.smn.dto.CiudadDTO;
import com.desi.smn.model.Ciudad;
import com.desi.smn.model.Provincia;
import com.desi.smn.service.ICiudadService;
import com.desi.smn.service.IClimaService;
import com.desi.smn.service.IProvinciaService;

@Controller
@RequestMapping("/ciudad")
public class CiudadController {

	@Autowired
	private ICiudadService ciudadService;

	@Autowired
	private IProvinciaService provinciaService;
	
	@Autowired(required = false)
	private IClimaService climaService;

	@RequestMapping(method = RequestMethod.POST)
	public String guardar(@ModelAttribute("ciudadDTO") CiudadDTO ciudadDTO, @RequestParam String action) {
		
		if("Aceptar".equals(action)) {
			
			Ciudad ciudad = ciudadDTO.toModel();

			ciudad.setProvincia(provinciaService.getById(ciudadDTO.getIdProvincia()));
			ciudadService.guardar(ciudad);

			return "redirect:/ciudad";
	
		} else {
			
			return "redirect:/";
		}

		
	}

	@ModelAttribute("allProvincias")
	public List<Provincia> getAllProvincias() {
		return provinciaService.getAll();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String paginaCiudad(@ModelAttribute("ciudadDTO") CiudadDTO ciudadDTO) {
		return "ciudad";
	}

}
