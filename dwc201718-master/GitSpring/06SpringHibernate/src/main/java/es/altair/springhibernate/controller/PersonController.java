package es.altair.springhibernate.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;

import javax.imageio.ImageIO;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.altair.springhibernate.bean.Person;
import es.altair.springhibernate.dao.PersonDAO;

@Controller
public class PersonController {

	@Autowired
	private PersonDAO personDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String inicio(Model model, @ModelAttribute("persona") final Person mappingPersona) {
		if (mappingPersona != null)
			model.addAttribute("person", mappingPersona);
		else
			model.addAttribute("person", new Person());

		model.addAttribute("listPersons", personDAO.listPersons());
		return "principal";
	}

	@RequestMapping(value = "/addedit", method = RequestMethod.POST)
	public String addEditPerson(@ModelAttribute Person p) {
		if (p.getId() == 0)
			personDAO.addPerson(p);
		else
			personDAO.editPerson(p);
		return "redirect:/";
	}

	@RequestMapping(value = "/edit/{idPerson}")
	public String editPerson(@PathVariable("idPerson") int id, final RedirectAttributes redirectAttributes) {
		Person p = personDAO.getPersonById(id);

		// model.addAttribute("person", p);
		// model.addAttribute("listPersons", personDAO.listPersons());

		// return "principal";

		redirectAttributes.addFlashAttribute("persona", p);

		return "redirect:/";

	}

	@RequestMapping(value = "/delete/{idPerson}")
	public String deletePerson(@PathVariable("idPerson") int id) {
		personDAO.deletePerson(id);
		return "redirect:/";
	}

	@RequestMapping(value = "/addPersonNew", method = RequestMethod.GET)
	public String addPersonNew(Model model) {

		model.addAttribute("person", new Person());

		return "addPerson";
	}

	@RequestMapping(value = "/addNew", method = RequestMethod.POST)
	public String addPersonDefNew(@ModelAttribute Person p, 
			@RequestParam("file") MultipartFile file) {

		Blob blob;
		try {
			BufferedImage imageBuffer = ImageIO.read(file.getInputStream());
			Image tmp = imageBuffer.getScaledInstance(640, 640, BufferedImage.SCALE_FAST);
			BufferedImage buffered = new BufferedImage(640, 640, BufferedImage.TYPE_INT_RGB);
			buffered.getGraphics().drawImage(tmp, 0, 0, null);

			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(buffered, "jpg", os);

			blob = personDAO.obtenerBlobFromFile(os.toByteArray());
			p.setImagen(blob);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		personDAO.addPerson(p);

		return "redirect:/";
	}
}
