package com.desi.smn.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.desi.smn.model.Ciudad;
import com.desi.smn.model.Evento;
import com.desi.smn.service.ICiudadService;
import com.desi.smn.service.EventoService;



@Controller
@RequestMapping("/eventoEditar")
public class EventoEditarController {
	@Autowired
    private EventoService servicioEvento;
	
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
    
    @RequestMapping(path="")
    public String preparaForm(Model modelo){
    	modelo.addAttribute("formBean",new EventoForm());
		return "eventoEditar";
    }
 
    
    @RequestMapping( method=RequestMethod.POST)
    public String submit(@ModelAttribute("formBean") /*@Valid*/  EventoForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action) {
    	
    	
    	if(action.equals("Aceptar"))
    	{
    		
    		if(result.hasErrors())
    		{
    			
                
    			modelo.addAttribute("formBean",formBean);
    			 return "eventoEditar";
    		}
    		else
    		{
    		//	try {
    			Evento e =formBean.toPojo();
    			e.setCiudad(servicioCiudad.getById(formBean.getIdCiudad()));
    			servicioEvento.save(e);
    			
    			return "redirect:/";
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
    		}

    	
        	
    	}
    
    	
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/";
    	}
    		
    	return "redirect:/";
    	
    	
    }

 
}

