package com.desi.smn.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/climaEditar")
public class ClimaEditarController {
	@Autowired(required = false)
	private IClimaService climaService;

	@Autowired
	private ICiudadService ciudadService;
	
	@Autowired
	private IEstadoService estadoService;
	
	@RequestMapping(path = {"", "/{id}"},method=RequestMethod.GET)
    public String preparaForm(Model modelo, @PathVariable("id") Optional<Long> id){
    	if (id.isPresent()) {
    		Clima clima = climaService.getById(id.get());
    		ClimaDTO climaDTO = new ClimaDTO(clima);
			modelo.addAttribute("climaDTO", climaDTO);
		} else {
	       modelo.addAttribute("climaDTO", new ClimaDTO());
		}
       return "climaEditar";
    }
    
	@ModelAttribute("allCiudades")
	public List<Ciudad> getAllCiudades() {
		return this.ciudadService.getAll();
	}
    
	@ModelAttribute("allEstados")
	public List<Estado> getAllEstados() {
		return this.estadoService.getAll();
	}
	
    @RequestMapping( method=RequestMethod.POST)
    public String submit(@ModelAttribute("climaDTO") @Valid  ClimaDTO climaDTO, BindingResult result, ModelMap modelo,@RequestParam String action) {
    	if(action.equals("Guardar")) {
			Clima clima = climaDTO.toModel();
			
			clima.setCiudad(ciudadService.getById(climaDTO.getIdCiudad()));
			clima.setEstado(estadoService.getById(climaDTO.getIdEstado()));
			for (Clima c : climaService.getAll()) {
				if(c.getCiudad().getId().equals(clima.getCiudad().getId())) {
					clima.setId(c.getId());
					break;
				}
			}
			climaService.guardar(clima);
			
			return "redirect:/clima";        	
    	}else if(action.equals("Cancelar")){
    		modelo.clear();
    		return "redirect:/clima";
    	}
    		
    	return "redirect:/";
    }
}
