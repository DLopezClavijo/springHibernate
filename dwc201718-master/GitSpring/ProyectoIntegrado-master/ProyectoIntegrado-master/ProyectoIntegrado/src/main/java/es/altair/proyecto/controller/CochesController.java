package es.altair.proyecto.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import es.altair.proyecto.bean.Coche;
import es.altair.proyecto.bean.Revisiones;
import es.altair.proyecto.bean.Usuario;
import es.altair.proyecto.dao.CocheDAO;
import es.altair.proyecto.dao.RevisionDAO;
import es.altair.proyecto.dao.UsuarioDAO;

@Controller
public class CochesController {

	@Autowired
	private CocheDAO cocheDAO; 
	
	@Autowired
	private UsuarioDAO usuarioDAO; 
	
	@Autowired
	private RevisionDAO revisionDAO; 
	
	@RequestMapping(value="/addCocheVista", method=RequestMethod.GET)
	public ModelAndView addCocheVista(@ModelAttribute Coche car, Model model, HttpSession sesion) {
		int idUsu = (Integer)sesion.getAttribute("idUsuario");
		Usuario usu = usuarioDAO.obtenerUsuPorId(idUsu); 
		return new ModelAndView("addCoche"); 
	}
	
	@RequestMapping(value="/addCocheAdminVista", method=RequestMethod.GET)
	public ModelAndView addCocheAdminVista(@ModelAttribute Coche car,@ModelAttribute Usuario usu,  Model model, HttpSession sesion, @RequestParam("idUsuario") String idUsuario, HttpServletRequest request) {
		//model.addAttribute("listClients", usuarioDAO.getClientList());
		int id = Integer.parseInt(request.getParameter("idUsuario"));

		sesion.setAttribute("usuarioCars",usuarioDAO.obtenerUsuPorId(id) );
		return new ModelAndView("addCocheAdmin"); 
	}
	
	@RequestMapping(value="/editarCarsAdmins", method=RequestMethod.GET)
	public ModelAndView editarCarsAdmins(@RequestParam("idCoche") String idCoche,@ModelAttribute Usuario usu,  Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("idCoche"));
		Coche c = cocheDAO.carsById(id);
		System.out.println("año: " + c.getAnyo());
		model.addAttribute("listClients", usuarioDAO.getClientList());

		
		return new ModelAndView("addCocheAdmin", "coche", c); 
	}
	
	@RequestMapping(value="/editCarsView", method=RequestMethod.GET)
	public ModelAndView editCarsView(@RequestParam("idCoche") String idCoche,@ModelAttribute Usuario usu,  Model model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("idCoche"));
		Coche c = cocheDAO.carsById(id);
		System.out.println("año: " + c.getAnyo());
		

		
		return new ModelAndView("addCoche", "coche", c); 
	}
	
	@RequestMapping(value="/addCarsWorks", method=RequestMethod.POST)
	public String addCarsWorks(@ModelAttribute Coche car, HttpSession sesion, HttpServletRequest request, 
			@RequestParam("file")MultipartFile file) {
		System.out.println("entramos en el controller");
		String mensaje =""; 
		Blob blob; 
		int filas = 0; 
		int tipo = (Integer)sesion.getAttribute("tipoUsuario");
		System.out.println("antes de coger el idUsuario");
		int idUsuario = (Integer)sesion.getAttribute("usuario");
		System.out.println("idUsuario: " + idUsuario);
		Usuario usu = usuarioDAO.obtenerUsuPorId(idUsuario); 

		if(usu == null) {
			mensaje="Confirme al usuario"; 
			return "redirect:/addCocheAdminVista?mensaje=Confirme al usuario" + mensaje ; 
		}else {
			car.setUsuario(usu);

			if(!cocheDAO.comprobarMatricula(car)) {
				System.out.println("matricula valida");
				try {
					BufferedImage imageBuffer = ImageIO.read(file.getInputStream());  
					Image tmp = imageBuffer.getScaledInstance(640, 640, BufferedImage.SCALE_FAST);
					BufferedImage buffered = new BufferedImage(640, 640, BufferedImage.TYPE_INT_RGB);
					buffered.getGraphics().drawImage(tmp, 0, 0, null); 
					
					ByteArrayOutputStream os = new ByteArrayOutputStream(); 
					ImageIO.write(buffered, "jgp", os); 
					
					blob = cocheDAO.obtenerImagen(os.toByteArray()); 
					
				} catch(HibernateException e ) {
					e.printStackTrace();
				}catch(IOException e ) {
					e.printStackTrace();
				} finally {
					
					filas = cocheDAO.addCar(car);
					if(filas == 1) {
						mensaje="Se ha añadido el coche correctamente"; 
						sesion.setAttribute("usuario", null);
						return "redirect:/addCocheAdminVista?mensaje=" + mensaje ; 
					}else {
						mensaje="No se ha añadido el coche "; 
					}
				}
			}else {
				mensaje = "La matricula ya existe"; 
				return "redirect:/addCocheAdminVista";
			}
			return "redirect:/addCocheAdminVista"; 
		}
		

		

	
}

	@RequestMapping(value="/addCocheByWorks", method=RequestMethod.POST)
	public String addCocheWorks(@ModelAttribute Coche car, HttpSession sesion) {
		System.out.println("entramos en el metodo");
		System.out.println("Entramos en el addCoche");
		System.out.println();
		System.out.println("Matricula: " + car.getMatricula());
		
		Usuario usu = (Usuario) sesion.getAttribute("usuarioCars"); 
		int filas = 0; 
		String mensaje = ""; 
		Blob blob; 
		
		car.setUsuario(usu);

		if(car.getIdCoche() == 0) {
			System.out.println("add");

			if(!cocheDAO.comprobarMatricula(car)) {
				System.out.println("matricula valida");
									
					filas = cocheDAO.addCar(car);
					//cocheDAO.añadirCoche(car); 
					if(filas == 1) {
						mensaje="Se ha añadido el coche correctamente"; 
						return "redirect:/usersInfoview?idUsuario="+ usu.getIdUsuario()+"&mensaje= " + mensaje; 
					}else {
						mensaje="No se ha añadido el coche "; 
					}
				
				
			}else {
				mensaje = "La matricula ya existe"; 
				return "redirect:/usersInfoview?idUsuario="+ usu.getIdUsuario()+"&mensaje= " + mensaje;  
			}
			}else {
				System.out.println("editar");
				if(!cocheDAO.comprobarMatricula(car)) {
					System.out.println("matricula valida");
					filas = cocheDAO.editarCars(car);
					//cocheDAO.añadirCoche(car); 
					if(filas == 1) {
						mensaje="Se ha añadido el coche correctamente"; 
						return "redirect:/usersInfoview?idUsuario="+ usu.getIdUsuario()+"&mensaje= " + mensaje; 
					}else {
						mensaje="No se ha añadido el coche "; 
					}
					
			}
		}
		return "redirect:/usersInfoview?idUsuario="+ usu.getIdUsuario()+"&mensaje= " + mensaje; 

	}
	
	@RequestMapping(value="/addCoche", method=RequestMethod.POST)
	public String addCoche(@ModelAttribute Coche car, HttpSession sesion) {
		int idUsuario = (Integer)sesion.getAttribute("idUsuario"); 
		System.out.println("Entramos en el addCoche");
		System.out.println("Id usuario: " + idUsuario);
		System.out.println("Matricula: " + car.getMatricula());
		
		Usuario usu = usuarioDAO.obtenerUsuPorId(idUsuario); 
		int filas = 0; 
		String mensaje = ""; 
	
		car.setUsuario(usu);
		if(car.getIdCoche() == 0 ) {
			if(!cocheDAO.comprobarMatricula(car)) {
				System.out.println("matricula valida");
				
				
				filas = cocheDAO.addCar(car);
				//cocheDAO.añadirCoche(car); 
				if(filas == 1) {
					mensaje="Se ha añadido el coche correctamente"; 
					return "redirect:/addCocheVista?mensaje=" + mensaje ; 
				}else {
					mensaje="No se ha añadido el coche "; 
				}
				
				
			}else {
				mensaje = "La matricula ya existe"; 
				return "redirect:/addCocheVista"; 
			}
		}else {
			if(!cocheDAO.comprobarMatricula(car)) {
				System.out.println("matricula valida");
				filas = cocheDAO.editarCars(car);
				//cocheDAO.añadirCoche(car); 
				if(filas == 1) {
					mensaje="Se ha editado el coche correctamente"; 
					return "redirect:/PrincipalCliente?fallo=Se ha editado el coche correctamente";
				}else {
					mensaje="No se ha podido editar el coche "; 
					return "redirect:/addCoche/?fallo=Se ha editado el coche correctamente"; 
				}
		}
		}
		return "redirect:/addCocheVista"; 
	}

	@RequestMapping(value = "/deleteCarsbyAdmin", method = RequestMethod.GET)
	public String deleteUsersbyAdmin(@ModelAttribute Coche car, HttpSession sesion,
			@RequestParam("idCoche") String idCoche, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("idCoche"));
		Coche c = cocheDAO.carsById(id); 
		cocheDAO.deleteCars(car);
		String mensaje ="coche eliminado";
		return "redirect:/usersInfoview?idUsuario="+ c.getUsuario().getIdUsuario()+"&mensaje= " + mensaje; 

	}
	
	@RequestMapping(value = "/deleteCars", method = RequestMethod.GET)
	public String deleteCars(@ModelAttribute Coche car, HttpSession sesion,
			@RequestParam("idCoche") String idCoche, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("idCoche"));
		Coche c = cocheDAO.carsById(id); 
		List<Revisiones> l = revisionDAO.getRevisionsByCars(c);
		if(l != null ) {
			revisionDAO.deleteRevisionByCars(car);
			cocheDAO.deleteCars(car);
			String mensaje ="coche eliminado";
			return "redirect:/PrincipalCliente?fallo=coche eliminado" + mensaje;
		}else {
			cocheDAO.deleteCars(car);
			String mensaje ="coche eliminado";
			return "redirect:/PrincipalCliente?fallo=coche eliminado" + mensaje; 
		}
		

	}
	
	
	private String returnAdminWorkers(int tipo) {
		if (tipo == 0) {
			return "redirect:/PrincipalAdmin";
		} else {
			return "redirect:/PrincipalCliente";
		}
	}
	
	
}

