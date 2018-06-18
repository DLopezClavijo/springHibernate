package es.altair.springhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import es.altair.springhibernate.dao.LibroDAO;

@Controller
public class UsuariosController {

	@Autowired
	LibroDAO libroDAO;
	
	@RequestMapping(value = "/principalUsu", method = RequestMethod.GET)
	public String principalUsu (Model model) {
				
		model.addAttribute("libros", libroDAO.listaLibro());
		
		return "/principalUsu";
	}

	@RequestMapping(value = "/principalAdmin", method = RequestMethod.GET)
	public String principalAdmin (Model model) {
				
		model.addAttribute("libros", libroDAO.listaLibro());
		
		return "/principalAdmin";
	}
}
