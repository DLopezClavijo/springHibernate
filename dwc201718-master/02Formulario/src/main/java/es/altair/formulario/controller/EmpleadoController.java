package es.altair.formulario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.altair.formulario.bean.Empleado;

@Controller
public class EmpleadoController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("home", "miEmp", new Empleado());
	}

	@RequestMapping(value = "/mostrar", method = RequestMethod.POST)
	public String mostrar(@ModelAttribute("empleado") Empleado empleado, ModelMap model) {
//		model.addAttribute("id", empleado.getIdEmpleado());
//		model.addAttribute("nombre", empleado.getNombre());
//		model.addAttribute("salario", empleado.getSalario());
//		model.addAttribute("edad", empleado.getEdad());
		
		model.addAttribute(empleado);
		
		return "mostrarEmp";
	}
}
