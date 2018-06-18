package es.altair.springhibernate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.altair.springhibernate.bean.Usuarios;
import es.altair.springhibernate.dao.UsuarioDAOImplHibernate;
import es.altair.springhibernate.dao.UsuarioDAO;

@Controller
public class LoginController {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home () {
				
		return "index";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home (Model model, @RequestParam(value="mensaje", required=false, defaultValue="") String mensaje) {
		
		model.addAttribute("mensaje", mensaje);
		
		return "/index";
	}
	
	@RequestMapping(value = "/ValidarUsuario", method = RequestMethod.POST)
	public ModelAndView validarUsuario (HttpServletRequest request, HttpServletResponse response) {
		
		String login = request.getParameter("usuario");
		String password = request.getParameter("password");
				
		Usuarios usu = usuarioDAO.comprobarUsuario(login, password);
		
		if (usu!=null) {
			
			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuLogeado", usu);
			
			switch (usu.getTipo()) {
			case 0:
				// Usuario Normal
				return new ModelAndView("redirect:/principalUsu", "", "");
			case 1:
				// Administrador
				return new ModelAndView("redirect:/principalAdmin", "", "");

			}
			System.out.println(usu);
		} else {
			// Error Usuario
			return new ModelAndView("/index", "mensaje", "Usuario y/o Password Incorrecto");
		}
		
		return new ModelAndView("/index", "", "");
	}
}
