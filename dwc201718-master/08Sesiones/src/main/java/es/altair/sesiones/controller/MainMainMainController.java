package es.altair.sesiones.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import es.altair.sesiones.bean.EmployeeDetails;

@Controller
@SessionAttributes("empObject")
public class MainMainMainController {
 
	@RequestMapping(value = "/secondPage", method = RequestMethod.GET)
	public String inicio(Model m) {
		m.addAttribute(new EmployeeDetails());
		
		return "secondPage";
	}
	
	@RequestMapping(value = "/showFinalObject", method = RequestMethod.POST)
	public ModelAndView showFinal(@ModelAttribute EmployeeDetails emplo) {
		System.out.println(emplo.getFullName() + " " + emplo.getDepartment());
 
		ModelAndView mv = new ModelAndView("final");
		mv.addObject("empObject", emplo);
 
		return mv;
 
	}

	@RequestMapping(value = "/close", method = RequestMethod.GET)
	public String close(SessionStatus status) {
		status.setComplete();
		return "closed";
	}
}