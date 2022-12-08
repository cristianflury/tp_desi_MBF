package com.desi.smn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.desi.smn.model.Subscripto;
import com.desi.smn.service.ISubscriptoService;

@Controller
public class SubscriptoController {
	
	@Autowired(required=false)
	private ISubscriptoService servicioSubscripto;
	
	
	@ModelAttribute("allSubscriptos")
	public List<Subscripto> getAllSubscriptos() {
		return this.servicioSubscripto.getAll();
	}

}
