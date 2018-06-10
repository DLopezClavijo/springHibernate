package es.altair.formulariovalidacion.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.altair.formulariovalidacion.bean.Alumno;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("alumno", new Alumno());
		return "home";
	}

	@RequestMapping(value = "/mostrar", method = RequestMethod.POST)
	public String mostrarInfoAlumno(@Valid Alumno alumno, BindingResult result, Model m) {
		if (!result.hasErrors())
			m.addAttribute("mensaje", "Alumno Correcto");		
		
		return "home";
	}
}
