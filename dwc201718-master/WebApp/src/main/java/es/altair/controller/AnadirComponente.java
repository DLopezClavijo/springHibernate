package es.altair.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import es.altair.bean.Componente;
import es.altair.bean.Usuario;
import es.altair.dao.ComponenteDAO;
import es.altair.dao.ComponenteDAOImplHibernate;

/**
 * Servlet implementation class AnadirComponente
 */
@MultipartConfig
public class AnadirComponente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnadirComponente() {
		super();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String modelo = request.getParameter("modelo");
		String marca = request.getParameter("marca");
		int precio = Integer.parseInt(request.getParameter("precio"));

		
		Part filePart = request.getPart("foto");

		InputStream inputS = null;
		ByteArrayOutputStream os = null;
		if (!getFileName(filePart).equals("")) {
			inputS = filePart.getInputStream();

			
			BufferedImage imageBuffer = ImageIO.read(inputS);
			Image tmp = imageBuffer.getScaledInstance(640, 640, BufferedImage.SCALE_FAST);
			BufferedImage buffered = new BufferedImage(640, 640, BufferedImage.TYPE_INT_RGB);
			buffered.getGraphics().drawImage(tmp, 0, 0, null);

			os = new ByteArrayOutputStream();
			ImageIO.write(buffered, "jpg", os);
		}

		HttpSession sesion = request.getSession();

		ComponenteDAO cDAO = new ComponenteDAOImplHibernate();

		Componente c = new Componente(modelo, marca, precio, os.toByteArray(),
				((Usuario) sesion.getAttribute("usuLogeado")));
		
		cDAO.insertar(c);

		response.sendRedirect("jsp/principalUsu.jsp");

	}

	private String getFileName(Part filePart) {
		for (String content : filePart.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 1).trim().replace("\"", "");
		}
		return null;
	}

}
