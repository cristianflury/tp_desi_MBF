package com.desi.smn.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.desi.smn.service.ISubscriptoService;

@Controller
public class SubscriptoController {
	
	@Autowired(required=false)
	private ISubscriptoService servicioSubscripto;
	
	
	//@ModelAttribute("allSubscriptos")
	//public List<Subscripto> getAllSubscriptos() {
	//	return this.servicioSubscripto.getAll();
	//}

}
