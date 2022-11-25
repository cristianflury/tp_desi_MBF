package com.desi.smn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.desi.smn.dto.ClimaDTO;
import com.desi.smn.model.Ciudad;
import com.desi.smn.model.Clima;
import com.desi.smn.model.Provincia;
import com.desi.smn.service.ICiudadService;
import com.desi.smn.service.IClimaService;
import com.desi.smn.service.IProvinciaService;

import ch.qos.logback.core.joran.action.Action;

@Controller
@RequestMapping("/clima")
public class ClimaController {
	
	@Autowired(required = false)
	private IClimaService climaService;
	
	@Autowired
	private IProvinciaService provinciaService; //Probablemente lo borre
	
	@Autowired
	private ICiudadService ciudadService;

	
	//CLASE 8, min 57 seguramente me sirva para cuando quiera hacer el editar
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("climaDTO") ClimaDTO climaDTO, ModelMap modelo,@RequestParam String action) {
		if(action.equals("Guardar")) {
			Clima clima = climaDTO.toModel();
			
			clima.setCiudad(ciudadService.getById(climaDTO.getIdCiudad()));
			for (Clima c : climaService.getAll()) {
				if(c.getCiudad().getId().equals(clima.getCiudad().getId())) {
					clima.setId(c.getId());
					break;
				}
			}
			climaService.guardar(clima);
			
			return "redirect:/clima";		
			
		}else if(action.equals("Actualizar")) {
//			Clima clima = climaService.filter(climaDTO);
//			System.out.println(clima.getId() + " asd");
			List<Clima> clima = climaService.getAll();
			modelo.addAttribute("resultados", clima);
			modelo.addAttribute("climaDTO", climaDTO);
			
			return "clima";
		}else {
			return "redirect:/";
		}
	}

	/*SI FALLA BORRAR DE ACA*/
	
	/*SI FALLA BORRAR HASTA ACÁ*/
	
	@ModelAttribute("allCiudades")
	public List<Ciudad> getAllCiudades() {
		return this.ciudadService.getAll();
	}
	
	/*@ModelAttribute("editarClima")
	public Clima getClimaEditar(@ModelAttribute("climaDTO") ClimaDTO climaDTO, ModelMap modelo) {
		Clima clima = climaDTO.toModel();
		
		clima.setCiudad(ciudadService.getById(climaDTO.getIdCiudad()));
		for (Clima c : climaService.getAll()) {
			if(c.getCiudad().getId().equals(clima.getCiudad().getId())) {
				clima.setId(c.getId());
				break;
			}
		}
		
		return clima;
	}*/
	
	@RequestMapping(method = RequestMethod.GET)
	public String paginaClima(@ModelAttribute("climaDTO") ClimaDTO climaDTO, ModelMap modelo) {
		List<Clima> clima = climaService.getAll();
		modelo.addAttribute("resultados", clima);
		modelo.addAttribute("climaDTO", climaDTO);
		return "clima";
	}
}
