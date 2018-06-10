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

import es.altair.proyecto.bean.Coche;
import es.altair.proyecto.bean.Reparaciones;
import es.altair.proyecto.bean.Revisiones;
import es.altair.proyecto.bean.Usuario;
import es.altair.proyecto.dao.CocheDAO;
import es.altair.proyecto.dao.ReparacionDAO;
import es.altair.proyecto.dao.RevisionDAO;

@Controller
public class RevisionController {
	
	@Autowired
	private RevisionDAO revisionDAO;
	
	@Autowired
	private CocheDAO cocheDAO;
	
	@Autowired
	private ReparacionDAO reparacionDAO; 

	@RequestMapping(value="/revisionsVistaByCars", method=RequestMethod.GET)
	public ModelAndView CarsRevisionsVista(  @RequestParam("idCoche") String idCoche,  Model model, HttpSession sesion, HttpServletRequest request) {

		int idCars = Integer.parseInt(request.getParameter("idCoche"));
		System.out.println("idCars: " + idCars);
		Coche cars = cocheDAO.carsById(idCars); 
		model.addAttribute("coche", cars); 
		sesion.setAttribute("coche2", cars);
		model.addAttribute("listRevisionsById", revisionDAO.getRevisionsByCars(cars)); 
		
		return new ModelAndView("revisionview"); 
	}
	
	
	@RequestMapping(value="/revisionsVistaByCarsClient", method=RequestMethod.GET)
	public ModelAndView CarsRevisionsClientVista(  @RequestParam("idCoche") String idCoche,  Model model, HttpSession sesion, HttpServletRequest request) {

		int idCars = Integer.parseInt(request.getParameter("idCoche"));
		System.out.println("idCars: " + idCars);
		Coche cars = cocheDAO.carsById(idCars); 
		model.addAttribute("coche", cars); 
		sesion.setAttribute("coche2", cars);
		model.addAttribute("listRevisionsById", revisionDAO.getRevisionsByCars(cars)); 
		
		return new ModelAndView("revisionViewClient"); 
	}
	
	@RequestMapping(value="/addRevisionView", method=RequestMethod.GET)
	public ModelAndView addRevisionView(@ModelAttribute Revisiones revisiones, @ModelAttribute Reparaciones reparaciones,  Model model, HttpSession sesion, HttpServletRequest request) {
		model.addAttribute("listRepair", reparacionDAO.getRepairList()); 
		System.out.println("entramos en addRevisionView");
		return new ModelAndView("addRevisions");
	}
	
		
	@RequestMapping(value = "/addRevision", method = RequestMethod.POST)
	public String addRevision(@ModelAttribute Revisiones revi, HttpSession sesion) {
		String mensaje = "";
		int filas = 0; 
		Reparaciones repa = (Reparaciones) sesion.getAttribute("reparacion"); 
		Coche coche = (Coche)sesion.getAttribute("coche2");
		System.out.println("coche: " + coche.getIdCoche());

		if(repa == null) {
			mensaje = "Elija una reparación"; 
			return "redirect:/addRevisionView?mensaje=" + mensaje; 

		}else {
			System.out.println("Añadir");
			revi.setCoche(coche);
			
			revi.setReparacion(repa);
			filas = revisionDAO.addRevisions(revi); 
			System.out.println("Fecha: " + revi.getFecha());
			System.out.println("Kilometros: " + revi.getKilometros());
			System.out.println("Observaciones: " + revi.getObservaciones());
			sesion.setAttribute("reparacion", null);

			return "redirect:/revisionsVistaByCars?idCoche=" + coche.getIdCoche(); 
		}
		
	}

	@RequestMapping(value = "/borrarRevision", method = RequestMethod.GET)
	public String deleteUsers(@ModelAttribute Revisiones revi, HttpSession sesion,
			@RequestParam("idRevision") String idRevision, HttpServletRequest request) {
		Coche coche = (Coche)sesion.getAttribute("coche2");
		System.out.println("coche: " + coche.getIdCoche());
		int idRevi = Integer.parseInt(request.getParameter("idRevision"));
		System.out.println("idRevi: " + idRevi);
		revisionDAO.deleteRevisions(idRevi); 
		return "redirect:/revisionsVistaByCars?idCoche=" + coche.getIdCoche(); 

	}

}
