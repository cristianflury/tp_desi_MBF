package com.desi.smn.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.desi.smn.dto.ClimaDTO;
import com.desi.smn.model.Ciudad;
import com.desi.smn.model.Clima;
import com.desi.smn.service.ICiudadService;
import com.desi.smn.service.IClimaService;
import com.desi.smn.service.IProvinciaService;
import com.tsti.smn.pojos.Provincia;

@Controller
@RequestMapping("/climaEditar")
public class ClimaEditarController {
	@Autowired(required = false)
	private IClimaService climaService;
	
	@Autowired
	private IProvinciaService provinciaService; //Probablemente lo borre
	
	@Autowired
	private ICiudadService ciudadService;
	
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
	
    @RequestMapping( method=RequestMethod.POST)
    public String submit(@ModelAttribute("climaDTO") @Valid  ClimaDTO climaDTO, BindingResult result, ModelMap modelo,@RequestParam String action) {
    	if(action.equals("Guardar")) {
    		if(result.hasErrors())
    		{
    			modelo.addAttribute("climaDTO",climaDTO);
    			 return "climaEditar";
    		}
    		else
    		{
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
    			
    		}
    	}else if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/clima";
    	}
    		
    	return "redirect:/";
    }
}
