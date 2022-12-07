package com.desi.smn.controller;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.desi.smn.dto.CiudadDTO;
import com.desi.smn.dto.PronosticoDTO;
import com.desi.smn.model.Ciudad;
import com.desi.smn.model.Pronostico;
import com.desi.smn.service.ICiudadService;
import com.desi.smn.service.IPronosticoService;

@Controller
@RequestMapping("/pronostico")
public class PronosticoController {

	@Autowired
	private IPronosticoService pronosticoService;

	@Autowired
	private ICiudadService ciudadService;

	@RequestMapping(method = RequestMethod.POST)
	public String guardar(@ModelAttribute("pronosticoDTO") @Valid PronosticoDTO pronosticoDTO, BindingResult result,
			ModelMap model, @RequestParam String action) throws Exception {

		if ("Aceptar".equals(action)) {

			if (result.hasErrors()) {

				model.addAttribute("pronosticoDTO", pronosticoDTO);
				return "pronosticoAgregar";

			} else {

				Pronostico pronostico = pronosticoDTO.toModel();

				Ciudad ciudad = ciudadService.getById(pronosticoDTO.getIdCiudad());

				pronostico.setCiudad(ciudad);

				try {

					pronosticoService.validarPronostico(pronostico, ciudad);

				} catch (Exception e) {

					ObjectError error = new ObjectError("globalError", e.getMessage());
					result.addError(error);

					model.addAttribute("pronosticoDTO", pronosticoDTO);
					return "pronosticoAgregar";

				}

				pronosticoService.guardar(pronostico);

				return "redirect:/pronostico/datos" + "?idCiudad=" + pronosticoDTO.getIdCiudad() + "&action=" + action;

			}

		} else {

			return "redirect:/pronostico/datos" + "?idCiudad=" + pronosticoDTO.getIdCiudad() + "&action=Aceptar";
		}

	}

	@RequestMapping(path = "/editarPronostico", method = RequestMethod.POST)
	public String editar(@ModelAttribute("pronosticoDTO") @Valid PronosticoDTO pronosticoDTO, BindingResult result,
			ModelMap model, @RequestParam String action) {

		if ("Aceptar".equals(action)) {

			if (result.hasErrors()) {

				model.addAttribute("pronosticoDTO", pronosticoDTO);
				return "pronosticoEditar";

			} else {

				Pronostico pronostico = pronosticoDTO.toModel();

				Ciudad ciudad = ciudadService.getById(pronosticoDTO.getIdCiudad());

				pronostico.setCiudad(ciudad);

				pronosticoService.guardar(pronostico);

				return "redirect:/pronostico/datos" + "?idCiudad=" + pronosticoDTO.getIdCiudad() + "&action=" + action;

			}

		} else {

			return "redirect:/pronostico/datos" + "?idCiudad=" + pronosticoDTO.getIdCiudad() + "&action=Aceptar";
		}

	}

	@ModelAttribute("allCiudades")
	public List<Ciudad> getAllCiudades() {
		return ciudadService.getAll();
	}

	@RequestMapping(path = "/agregar/{id}", method = RequestMethod.GET)
	public String paginaPronosticoAgregar(@ModelAttribute("pronosticoDTO") PronosticoDTO pronosticoDTO,
			@PathVariable("id") Long id) {

		pronosticoDTO.setIdCiudad(id);

		return "pronosticoAgregar";
	}

	@RequestMapping(path = "editar/{id}", method = RequestMethod.GET)
	public String paginaPronosticoEditar(@PathVariable("id") Long id, Model model) {

		Pronostico pronostico = pronosticoService.getById(id);
		PronosticoDTO pronosticoDTO = new PronosticoDTO(pronostico);
		model.addAttribute("pronosticoDTO", pronosticoDTO);

		return "pronosticoEditar";
	}

	@RequestMapping(value = "/datos", params = "idCiudad", method = RequestMethod.GET)
	public String paginaPronostico(Model model, @RequestParam Long idCiudad, @RequestParam String action) {

		if ("Aceptar".equals(action)) {

			Ciudad ciudad = ciudadService.getById(idCiudad);

			CiudadDTO ciudadDTO = new CiudadDTO(ciudad);
			List<Pronostico> pronosticos = ciudadDTO.getPronostico();

			List<Pronostico> pronosticosFiltrados = pronosticos.stream()
					.filter(p -> p.getFechaPronosticada().after(Date.from(Instant.now()))).toList();

			model.addAttribute("pronosticos", pronosticosFiltrados);
			model.addAttribute("idCiudad", idCiudad);

			return "pronostico";

		} else {

			return "redirect:/";
		}

	}

	@RequestMapping(path = "/ciudadElegir", method = RequestMethod.GET)
	public String paginaCiudadElegir(@ModelAttribute("pronosticoDTO") PronosticoDTO pronosticoDTO) {
		return "ciudadElegir";
	}

}
