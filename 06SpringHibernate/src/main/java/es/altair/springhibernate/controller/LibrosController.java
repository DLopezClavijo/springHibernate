package es.altair.springhibernate.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.altair.springhibernate.bean.Libros;
import es.altair.springhibernate.dao.LibroDAOImplHibernate;
import es.altair.springhibernate.dao.LibroDAO;

@Controller
public class LibrosController {

	@Autowired
	LibroDAO libroDAO;

	@RequestMapping(value = "/BorrarLibro", method = RequestMethod.POST)
	public String BorrarLibro(HttpServletRequest request, HttpServletResponse response) {

		String uuid = request.getParameter("uuid");

		Libros libro = libroDAO.obtenerLibroPorUUID(uuid);
		libroDAO.borrar(libro);

		return "redirect:/principalAdmin";
	}

	@RequestMapping(value = "/BorrarLibro", method = RequestMethod.POST)
	public String AnadirLibro(HttpServletRequest request, HttpServletResponse response) {

		String uuid = UUID.randomUUID().toString();
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		int isbn = Integer.parseInt(request.getParameter("isbn"));
		int precio = Integer.parseInt(request.getParameter("precio"));
		// Tratamiento de la imagen
		Part filePart = request.getPart("portada");

		InputStream inputS = null;
		ByteArrayOutputStream os = null;
		if (!getFileName(filePart).equals("")) {
			inputS = filePart.getInputStream();

			// Escalar la imagen
			BufferedImage imageBuffer = ImageIO.read(inputS);
			Image tmp = imageBuffer.getScaledInstance(640, 640, BufferedImage.SCALE_FAST);
			BufferedImage buffered = new BufferedImage(640, 640, BufferedImage.TYPE_INT_RGB);
			buffered.getGraphics().drawImage(tmp, 0, 0, null);

			os = new ByteArrayOutputStream();
			ImageIO.write(buffered, "jpg", os);
		}

		HttpSession sesion = request.getSession();

		LibroDAO lDAO = new LibroDAOImplHibernate();
		Libros l = new Libros(titulo, autor, isbn, os.toByteArray(), uuid, precio);

		lDAO.insertar(l);
		
		return "redirect:/principalAdmin";
	}

}
