package com.desi.smn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.desi.smn.dto.ProvinciaDTO;
import com.desi.smn.service.IProvinciaService;

@Controller
@RequestMapping("/provincia")
public class ProvinciaController {
	
	@Autowired
	private IProvinciaService provinciaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public String guardar(@ModelAttribute("provinciaDTO")ProvinciaDTO provinciaDTO) {
		
		provinciaService.guardar(provinciaDTO.toModel());
		
		return "redirect:/provincia";
		
		
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String paginaProvincia(@ModelAttribute("provinciaDTO")ProvinciaDTO provinciaDTO) {
		return "provincia";
	}
	
	
	

}
