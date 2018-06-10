package es.altair.proyecto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.altair.proyecto.bean.Reparaciones;
import es.altair.proyecto.bean.Usuario;
import es.altair.proyecto.dao.ReparacionDAO;
@Controller
public class ReparacionController {
	@Autowired
	private ReparacionDAO reparacionDAO; 
	
	@RequestMapping(value="/addRepairAdminVista", method=RequestMethod.GET)
	public ModelAndView addRepair (Model model, HttpSession sesion) {
		
		return new ModelAndView("addRepair", "reparacion", new Reparaciones());

	}
	
	@RequestMapping(value="/editRepairAdminVista", method=RequestMethod.GET)
	public ModelAndView editRepair(Model mode, HttpSession sesion, @RequestParam("idReparacion") String idReparacion, HttpServletRequest request) {
		int idRepa = Integer.parseInt(request.getParameter("idReparacion"));
		System.out.println("idReparaciones: " + idRepa);
		Reparaciones repa = reparacionDAO.obtenerReparacionById(idRepa); 
		
		return new ModelAndView("editRepair", "reparacion", repa); 
	}

	
	@RequestMapping(value ="/deleteRepair", method = RequestMethod.GET)
	public String deleteRepair(@ModelAttribute Reparaciones repa, HttpSession sesion,
			@RequestParam("idReparacion") String idReparacion, HttpServletRequest request) {
		int tipo = (Integer) sesion.getAttribute("tipoUsuario");
		int idRepa = Integer.parseInt(request.getParameter("idReparacion"));
		System.out.println("idReparacion: " + idRepa);
		reparacionDAO.deleteRepair(idRepa); 
		if (tipo == 0) {
			return "redirect:/PrincipalAdmin#repairList";
		} else {
			return "redirect:/PrincipalCliente";
		}
	}
	
	@RequestMapping(value = "/addRepair", method = RequestMethod.POST)
	public String addRepair(@ModelAttribute Reparaciones repa) {
		String mensaje = "";
		int filas = 0;
		if(!reparacionDAO.comprobarNombre(repa)) {
			filas = reparacionDAO.addRepair(repa); 
			if(filas == 1) {
				mensaje = "Reparacion Registrado";
				return "redirect:/PrincipalAdmin#repairList"; 
			}else {
				mensaje = "No se ha podido registrar la reparacióno";
				return "redirect:/addRepairAdminVista?mensaje=" + mensaje; 
			}
		}else {
			mensaje="La reparacion ya existe"; 
			return "redirect:/addRepairAdminVista"; 
		}
		
	}
	
	@RequestMapping(value = "/editRepair", method = RequestMethod.POST)
	public String editRepair(@ModelAttribute Reparaciones repa) {
		String mensaje = "";
		int filas = 0; 

		if(!reparacionDAO.comprobarNombre(repa)) {
			filas = reparacionDAO.editRepair(repa); 
			return "redirect:/PrincipalAdmin#repairList"; 
		}else {
			mensaje="La reparacion ya existe"; 
			return "redirect:/addRepairAdminVista"; 
		}
	}
	
	@RequestMapping(value = "/getReparacion", method = RequestMethod.GET)
	public String getReparacion(@ModelAttribute Reparaciones repa, HttpSession sesion) {
		System.out.println("capturamos la reparacion");
		System.out.println(repa.getIdReparacion());
		sesion.setAttribute("reparacion", reparacionDAO.obtenerReparacionById(repa.getIdReparacion()));

		return "redirect:/addRevisionView";
	}

	private String returnAdminWorkers(int tipo) {
		if (tipo == 0) {
			return "redirect:/PrincipalAdmin";
		} else {
			return "redirect:/PrincipalCliente";
		}
	}

}
