package es.altair.proyecto.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.altair.proyecto.dao.CocheDAO;

@Controller
public class ImageController {
	
	@Autowired
	private CocheDAO cocheDAO;
	
	@RequestMapping(value="/mostrarFoto", method =RequestMethod.GET)
	public void obtenerImagen (@RequestParam("idCoche") String idCoche, HttpServletResponse response , HttpServletRequest request )
		throws ServletException, IOException{
		System.out.println("imagen");
		int id = Integer.parseInt(request.getParameter("idCoche"));
		System.out.println("id: " + id );
		Blob imagen = cocheDAO.showImage(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		
		try {
			response.getOutputStream().write(imagen.getBytes(1,  (int)imagen.length()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getOutputStream().close();
	}

}
