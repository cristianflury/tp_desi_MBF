package com.desi.smn.service;

import com.desi.smn.model.Evento;
/**
 * Clase que permite gestionar la entidad Evento en el sistema.
 * @author Esteban
 * @version 1.0
 */

public interface IEventoService {

	/**
	 * Obtiene una evento determinado
	 * @param idEvento Identificador del evento buscado
	 * @return Evento encontrado
	 */
	Evento getById(Long idEvento);
	
	void save(Evento c);
	
	
	
}
