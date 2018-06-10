package es.altair.sesiones.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.altair.sesiones.bean.EmployeeDetails;

@Controller
@SessionAttributes("empFullName")
public class MainController {

	@RequestMapping(value = "/firstPage")
	public ModelAndView showFirstPage() {
		return new ModelAndView("firstPage");
	}
 
	@RequestMapping(value = "/showWelcome", method = RequestMethod.POST)
	public ModelAndView showWelcome(@RequestParam String fullName) {
 
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("empFullName", fullName);
 
		return mv;
 
	}
}
