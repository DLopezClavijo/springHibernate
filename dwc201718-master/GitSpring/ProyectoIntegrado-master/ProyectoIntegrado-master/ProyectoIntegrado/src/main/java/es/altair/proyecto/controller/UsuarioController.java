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
import es.altair.proyecto.bean.Usuario;
import es.altair.proyecto.dao.CocheDAO;
import es.altair.proyecto.dao.CocheDAOImpl;
import es.altair.proyecto.dao.ReparacionDAO;
import es.altair.proyecto.dao.RevisionDAO;
import es.altair.proyecto.dao.UsuarioDAO;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private CocheDAO cocheDAO;
	
	@Autowired
	private ReparacionDAO reparacionDAO; 
	
	@Autowired
	private RevisionDAO revisionDAO; 

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView Inicio(@RequestParam(value = "mensaje", required = false, defaultValue = "") String mensaje,
			Model model) {
		model.addAttribute("mensaje", mensaje);

		return new ModelAndView("home", "usuario", new Usuario());
	}
	
	@RequestMapping(value = "/addUsers", method = RequestMethod.POST)
	public String addUsers(@ModelAttribute Usuario Usu) {
		
		String mensaje = "";
		int filas = 0;

		if (!usuarioDAO.comprobarAlias(Usu)) {
			if (!usuarioDAO.comprobarCorreo(Usu)) {
				if (!usuarioDAO.comprobarTelefono(Usu)) {
					filas = usuarioDAO.addUsers(Usu);
					if (filas == 1) {
						mensaje = "Usuario Registrado";
						return "redirect:/addUsersView?mensaje=" + mensaje;
					} else {
						mensaje = "No se ha registrado al usuario";
						return "redirect:/addUsersView?mensaje=" + mensaje;
					}
				}else {
					mensaje = "El telefono ya existe";
					return "redirect:/addUsersView?mensaje=" + mensaje;
				
				}
			}else {
				mensaje = "El correo ya existe";
				return "redirect:/addUsersView?mensaje=" + mensaje;
			}
		}else {
			mensaje = "Usuario ya se encuentra registrado";
			return "redirect:/addUsersView?mensaje=" + mensaje;
		}
	}
	
	@RequestMapping(value = "/Registrar", method = RequestMethod.POST)
	public String registrarUsuario(@ModelAttribute Usuario Usu) {

		int filas = 0;
		String mensaje = "";
		System.out.println(Usu.getAlias());
		if (!usuarioDAO.comprobarAlias(Usu)) {
			if (!usuarioDAO.comprobarCorreo(Usu)) {
				System.out.println(Usu.getTelefono());
				if (!usuarioDAO.comprobarTelefono(Usu)) {
					System.out.println("vamos a registrar");
					filas = usuarioDAO.registrar(Usu);
					if (filas == 1) {
						mensaje = "Usuario Registrado";
						return "redirect:/#registrar?mensaje=" + mensaje;
					} else {
						mensaje = "No se ha registrado al usuario";
						return "redirect:/#registrar?mensaje=" + mensaje;
					}
				} else {
					mensaje = "El telefono ya existe";
					return "redirect:/#registrar?mensaje=" + mensaje;
				}
			} else {
				mensaje = "El correo ya existe";
				return "redirect:/#registrar?mensaje=" + mensaje;
			}

		} else {
			mensaje = "Usuario ya se encuentra registrado";
			return "redirect:/#registrar?mensaje=" + mensaje;
		}
	}

	@RequestMapping(value = "/inicioSesion", method = RequestMethod.POST)
	public String iniciarSesion(@ModelAttribute Usuario usu, HttpSession sesion) {
		usu = usuarioDAO.comprobarUsuario(usu.getAlias(), usu.getPassword());
		System.out.println(usu);
		if (usu != null) {
			sesion.setAttribute("usuarioLogeado", usu);
			sesion.setAttribute("tipoUsuario", usu.getTipo());
			sesion.setAttribute("idUsuario", usu.getIdUsuario());

			if (usu.getTipo() == 0)
				return "redirect:/PrincipalAdmin";
			else if (usu.getTipo() == 1)
				return "redirect:/PrincipalEmpleado";
			else
				return "redirect:/PrincipalCliente";
		} else {
			String mensaje = "Usuario y/o Password Incorrecto";

			return "redirect:/?mensaje=" + mensaje;
		}
	}

	@RequestMapping(value = "/PrincipalAdmin", method = RequestMethod.GET)
	public ModelAndView principalAdmin(Model model, HttpSession sesion) {
		//if(sesion.getAttribute("usuarioLogeado") != null) {

			int idUsu = (Integer) sesion.getAttribute("idUsuario");
			Usuario usu = usuarioDAO.obtenerUsuPorId(idUsu);
			model.addAttribute("usuario", usu);
			model.addAttribute("listAdministrator", usuarioDAO.getAdministrartorList());
			model.addAttribute("listClients", usuarioDAO.getClientList());
			model.addAttribute("listWorkers", usuarioDAO.getWorkersList());
			model.addAttribute("listCars", cocheDAO.getCarsList());
			model.addAttribute("listRepair", reparacionDAO.getRepairList());
			model.addAttribute("listRevisions", revisionDAO.getRevisionsList()); 
	
			return new ModelAndView("PrincipalAdmin");
		/*}else {
			return new ModelAndView("/home");

		}*/

		
	}

	@RequestMapping(value = "/PrincipalCliente", method = RequestMethod.GET)
	public ModelAndView principalCliente(@RequestParam(value="fallo",required=false,defaultValue="") String fallo , Model model, HttpSession sesion) {
		if(sesion.getAttribute("usuarioLogeado") != null) {
			int idUsu = (Integer) sesion.getAttribute("idUsuario");
			System.out.println("Id usuario en PrincipalCL: " + idUsu);
			Usuario usu = usuarioDAO.obtenerUsuPorId(idUsu);
			System.out.println(usu.getNombre() + " , " + usu.getApellido());
			model.addAttribute("usuario", usu);
			model.addAttribute("listaCoches", cocheDAO.listarById(usu));
			return new ModelAndView("PrincipalCliente");
		}else {
			return new ModelAndView("");

		}
	}
	
	@RequestMapping(value ="/PrincipalEmpleado", method = RequestMethod.GET)
	public ModelAndView principalTrabajador(Model model, HttpSession sesion) {
		int idUsu = (Integer) sesion.getAttribute("idUsuario");
		Usuario usu = usuarioDAO.obtenerUsuPorId(idUsu);
		model.addAttribute("usuario", usu);
		model.addAttribute("listClients", usuarioDAO.getClientList());
		model.addAttribute("listCars", cocheDAO.getCarsList());

		return new ModelAndView("PrincipalTrabajador");
	}

	@RequestMapping(value="/addUsersView", method=RequestMethod.GET)
	public ModelAndView addUsers(@ModelAttribute Usuario usu, Model model, HttpSession sesion) {
		return new ModelAndView("addUsers" , "usuario", new Usuario());
	}
	
	@RequestMapping(value="/editMyUsersView", method=RequestMethod.GET)
	public ModelAndView editMyUser(Model mode, HttpSession sesion) {
				
		Usuario usu = (Usuario)sesion.getAttribute("usuarioLogeado"); 
		
		return new ModelAndView("editUsers", "usuario", usu); 
	}
	
	@RequestMapping(value = "/editUsers", method = RequestMethod.POST)
	public String editMyUsers(@ModelAttribute Usuario Usu) {
		
		String mensaje = "";
		int filas = 0;

		if (!usuarioDAO.comprobarAlias(Usu)) {
			if (!usuarioDAO.comprobarCorreo(Usu)) {
				if (!usuarioDAO.comprobarTelefono(Usu)) {
					filas = usuarioDAO.editUsers(Usu);
					if (filas == 1) {
						mensaje = "Usuario editar";
						return "redirect:/PrincipalCliente?fallo=Usuario editado";
					} else {
						mensaje = "No se ha editado al usuario";
						return "redirect:/editMyUsersView?mensaje=" + mensaje;
					}
				}else {
					mensaje = "El telefono ya existe";
					return "redirect:/editMyUsersView?mensaje=" + mensaje;
				
				}
			}else {
				mensaje = "El correo ya existe";
				return "redirect:/editMyUsersView?mensaje=" + mensaje;
			}
		}else {
			mensaje = "Usuario ya se encuentra registrado";
			return "redirect:/editMyUsersView?mensaje=" + mensaje;
		}
	}
	
	@RequestMapping(value="/usersInfoview", method=RequestMethod.GET)
	public ModelAndView usersInfoView(Model model, HttpSession sesion,@RequestParam("idUsuario") String idUsuario, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("idUsuario"));
		model.addAttribute("u",usuarioDAO.obtenerUsuPorId(id)); 
		Usuario u = usuarioDAO.obtenerUsuPorId(id); 
		model.addAttribute("listCars", cocheDAO.listarById(u)); 
		return new ModelAndView("usersInfo"); 
	}
	
	@RequestMapping(value = "/cerrarSesion", method = RequestMethod.GET)
	public String cerrarSesion(HttpSession sesion) {
		sesion.setAttribute("usuarioLogeado",  null);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/return", method = RequestMethod.GET)
	public String regresar(HttpSession sesion) {
		if(sesion.getAttribute("tipoUsuario").equals(0)) {
			return "redirect:/PrincipalAdmin";
		}else if(sesion.getAttribute("tipoUsuario").equals(1)) {
			return "redirect:/PrincipalEmpleado";
		}else {
			return "redirect:/PrincipalCliente";
		}
	}

	@RequestMapping(value = "/borrarUsuario", method = RequestMethod.GET)
	public String deleteUsers(@ModelAttribute Usuario usu, HttpSession sesion,
			@RequestParam("idUsuario") String idUsuario, HttpServletRequest request) {
		int idUsu = Integer.parseInt(request.getParameter("idUsuario"));
		int id = (Integer) sesion.getAttribute("idUsuario");
		int tipo = (Integer) sesion.getAttribute("tipoUsuario");
		System.out.println("borrar usuario");
		int numCars = cocheDAO.carsByUsers(idUsu); 
		System.out.println("numero coches: " + numCars);
		//cocheDAO.deleteCars(idUsu);
		usuarioDAO.deleteUser(idUsu); 
		return returnAdminWorkers(tipo);

	}

	private String returnAdminWorkers(int tipo) {
		if (tipo == 0) {
			return "redirect:/PrincipalAdmin";
		} else {
			return "redirect:/PrincipalCliente";
		}
	}

	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public String getUsers(@ModelAttribute Usuario Usu, HttpSession sesion) {
		int tipo = (Integer) sesion.getAttribute("tipoUsuario");
		System.out.println(Usu.getIdUsuario());
		sesion.setAttribute("usuario", usuarioDAO.obtenerUsuPorId(Usu.getIdUsuario()));

		return "redirect:/addCocheAdminVista";
	}
	
}
