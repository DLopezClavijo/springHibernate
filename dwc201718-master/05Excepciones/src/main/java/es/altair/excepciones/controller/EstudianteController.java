package es.altair.excepciones.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.altair.excepciones.bean.Estudiante;
import es.altair.excepciones.exception.ExcepcionEstudiante;

@Controller
public class EstudianteController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("home", "estudiante", new Estudiante());
	}

	@RequestMapping(value = "/anadir", method = RequestMethod.POST)
	@ExceptionHandler({ExcepcionEstudiante.class})
	public String anadirEstudiante(@ModelAttribute("estudiante") Estudiante estudiante, ModelMap model) {
		if (estudiante.getNombre().length() < 5)
			throw new ExcepcionEstudiante("Nombre demasiado corto");
		else if (estudiante.getEdad() < 18)
			throw new ExcepcionEstudiante("Debe ser mayor de edad");
		else
			model.addAttribute(estudiante);
			
		return "resultado";
	}
}
