package es.altair.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import es.altair.mongodb.bean.Persona;
import es.altair.mongodb.dao.PersonaDAO;

@Controller
public class HomeController {
	
	@Autowired
	private PersonaDAO personaDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap m) {
		m.addAttribute("persona", new Persona());
		m.addAttribute("listado", personaDAO.listado());
		
		return "home";
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public View crearPersona(@ModelAttribute Persona p) {
		System.out.println(p.getId() + " " + p.getNombre());
		if (StringUtils.hasText(p.getId()))
			personaDAO.actualizar(p);
		else
			personaDAO.anadir(p);
		
		return new RedirectView("/mongodb/");
	}
	
	@RequestMapping(value = "/borrar", method = RequestMethod.GET)
	public View borrarPersona(@ModelAttribute Persona p) {
		System.out.println(p.getId() + " " + p.getNombre());
		personaDAO.borrar(p);
		
		return new RedirectView("/mongodb/");
	}
	
	@RequestMapping(value = "/actualizar", method = RequestMethod.GET)
	public String actualizarPersona(@ModelAttribute Persona p, ModelMap m) {
		Persona aux = personaDAO.obtener(p.getId());
		System.out.println(aux.getId() + " " + aux.getNombre());
		
		m.addAttribute("persona", aux);
		m.addAttribute("listado", personaDAO.listado());
		
		return "home";
	}
}
