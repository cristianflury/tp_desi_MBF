package com.desi.smn.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.desi.smn.dto.ClimaDTO;
import com.desi.smn.model.Ciudad;
import com.desi.smn.model.Clima;
import com.desi.smn.model.Estado;
import com.desi.smn.service.ICiudadService;
import com.desi.smn.service.IClimaService;
import com.desi.smn.service.IEstadoService;

@Controller
@RequestMapping("/clima")
public class ClimaController {
	
	@Autowired(required = false)
	private IClimaService climaService;

	@Autowired
	private ICiudadService ciudadService;

	@Autowired
	private IEstadoService estadoService;

	@RequestMapping(method = RequestMethod.POST)
	public String submit(@Valid @ModelAttribute("climaDTO") ClimaDTO climaDTO, BindingResult result, ModelMap modelo,@RequestParam String action) {
		if(action.equals("Registrar")) {
			
			
			for (Clima c : climaService.getAll()) {
				if(c.getCiudad().getId().equals(climaDTO.getIdCiudad())) {
					ObjectError error = new ObjectError("ciudadRegistrada", "La ciudad ingresada ya tiene un clima registrado");
					result.addError(error);
					break;
				}
			}
			
			if(result.hasErrors()) {
				List<Clima> clima = climaService.getAll();
				modelo.addAttribute("resultados", clima);
				modelo.addAttribute("climaDTO", climaDTO);
				return "clima";
			}else {
				Clima clima = climaDTO.toModel();
				clima.setCiudad(ciudadService.getById(climaDTO.getIdCiudad()));
				clima.setEstado(estadoService.getById(climaDTO.getIdEstado()));
				
				climaService.guardar(clima);
				
				return "redirect:/clima";		
			}
		}
		else {
			return "redirect:/";
		}
	}
	
	@ModelAttribute("allCiudades")
	public List<Ciudad> getAllCiudades() {
		return this.ciudadService.getAll();
	}
    
	@ModelAttribute("allEstados")
	public List<Estado> getAllEstados() {
		return this.estadoService.getAll();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String paginaClima(@ModelAttribute("climaDTO") ClimaDTO climaDTO, ModelMap modelo) {
		List<Clima> clima = climaService.getAll();
		modelo.addAttribute("resultados", clima);
		modelo.addAttribute("climaDTO", climaDTO);
		return "clima";
	}
}
