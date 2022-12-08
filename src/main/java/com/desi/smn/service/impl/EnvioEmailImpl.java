package com.desi.smn.service.impl;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Service;

import com.desi.smn.service.IEnvioEmail;

@Service
public class EnvioEmailImpl implements IEnvioEmail {
	

	@Override
	public void enviarEmail() {
		
		System.out.println("Envíando alerta de evento por e-mail a todos los subscriptos");
		
	}

}
