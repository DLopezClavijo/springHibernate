package es.altair.sesiones.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.altair.sesiones.bean.EmployeeDetails;

@Controller
@SessionAttributes("empObject")
public class MainMainController {
 
	@RequestMapping(value = "/showFinal", method = RequestMethod.POST)
	public ModelAndView showFinal(@RequestParam String fullName, @RequestParam String department) {
		System.out.println(fullName + " " + department);
		EmployeeDetails empDetails = new EmployeeDetails();
		empDetails.setFullName(fullName);
		empDetails.setDepartment(department);
 
		ModelAndView mv = new ModelAndView("final");
		mv.addObject("empObject", empDetails);
 
		return mv;
 
	}
}