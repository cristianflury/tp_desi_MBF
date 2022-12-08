package com.desi.smn.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.desi.smn.dto.EventoDTO;
import com.desi.smn.dto.SubscriptoDTO;
import com.desi.smn.model.Ciudad;
import com.desi.smn.model.Evento;
import com.desi.smn.model.Subscripto;
import com.desi.smn.service.ICiudadService;
import com.desi.smn.service.IEventoService;
import com.desi.smn.service.ISubscriptoService;



@Controller
@RequestMapping("/evento")
public class EventoEditarController {
	
	@Autowired(required=false)
    private IEventoService servicioEvento;
	
	@Autowired
    private ICiudadService servicioCiudad;
	
	//@Autowired(required = false)
    //private ISubscriptoService servicioSubscripto;

    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
        return this.servicioCiudad.getAll();
    }
    
   
    
    @RequestMapping(method = RequestMethod.GET)
    public String paginaEvento(@ModelAttribute("eventoDTO") EventoDTO eventoDTO, ModelMap modelo){
    	
   // 	List<Subscripto> sub = servicioSubscripto.getAll();
	//	modelo.addAttribute("Subscripto", sub);
		return "evento";
    }
 
    @PostMapping("/evento")
    @RequestMapping( method=RequestMethod.POST)
    public String guardar(@ModelAttribute("eventoDTO") @Valid EventoDTO eventoDTO, BindingResult result, ModelMap modelo, @RequestParam String action, @ModelAttribute("subscriptoDTO")SubscriptoDTO subscriptoDTO) {
    	
    	
    	if(action.equals("Aceptar"))
    	{
    		
    		if(result.hasErrors())
    		{

    			modelo.addAttribute("eventoDTO",eventoDTO);
   			  	return "evento";
    		}
    		else
    		{

    				Evento evento = eventoDTO.toModel();
    		    	
    		    	evento.setCiudad(servicioCiudad.getById(eventoDTO.getIdCiudad()));
    		    	
    		    	servicioEvento.save(evento);

    		    	
    		    	return "redirect:/";
    		    	
    		}

    	
        	
    	}
    
    	
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/";
    	}
    	return "redirect:/evento";	
    	
    	}	
    	
    }

 


