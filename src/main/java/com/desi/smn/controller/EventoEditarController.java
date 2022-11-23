package com.desi.smn.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.desi.smn.dto.EventoDTO;
import com.desi.smn.model.Ciudad;
import com.desi.smn.model.Evento;
import com.desi.smn.service.ICiudadService;
import com.desi.smn.service.IEventoService;



@Controller
@RequestMapping("/evento")
public class EventoEditarController {
	@Autowired
    private IEventoService servicioEvento;
	
	@Autowired
    private ICiudadService servicioCiudad;
 
     
    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
        return this.servicioCiudad.getAll();
    }
    
    @ModelAttribute("dia")
    public LocalDate dia() {
		return LocalDate.now();
	}
    
    @RequestMapping(method = RequestMethod.GET)
    public String paginaEvento(@ModelAttribute("eventoDTO") EventoDTO eventoDTO){
    	
		return "evento";
    }
 
    
    @RequestMapping( method=RequestMethod.POST)
    public String guardar(@ModelAttribute("eventoDTO") EventoDTO eventoDTO) {
    	
    	Evento evento = eventoDTO.toModel();
    	
    	evento.setCiudad(servicioCiudad.getById(eventoDTO.getIdCiudad()));
    	
    	servicioEvento.save(evento);
    	
    	
//    	if(action.equals("Aceptar"))
 //   	{
    		
 //   		if(result.hasErrors())
 //   		{
    			
                
//    			modelo.addAttribute("formBean",formBean);
//    			 return "eventoEditar";
//    		}
//    		else
//    		{
    		//	try {
//    			Evento e =formBean.toPojo();
//    			e.setCiudad(servicioCiudad.getById(formBean.getIdCiudad()));
//    			servicioEvento.save(e);
    			
//    			return "redirect:/";
 //   			} catch (Excepcion e) {
//					if(e.getAtributo()==null) //si la excepcion estuviera referida a un atributo del objeto, entonces mostrarlo al lado del compornente (ej. dni)
//					{
//						ObjectError error = new ObjectError("globalError", e.getMessage());
//			            result.addError(error);
//					}
//					else
//					{
//			    		FieldError error1 = new FieldError("formBean",e.getAtributo(),e.getMessage());
//			            result.addError(error1);
//
//					}
//		            modelo.addAttribute("formBean",formBean);
//	    			return "ciudadEditar";  //Como existe un error me quedo en la misma pantalla
//				}
 //   		}

    	
        	
  //  	}
    
    	
//    	if(action.equals("Cancelar"))
 //   	{
 //   		modelo.clear();
 //   		return "redirect:/";
 //   	}
  //  		
    	return "redirect:/evento";
    	
    	
    }

 
}

