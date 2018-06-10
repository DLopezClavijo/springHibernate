package es.altair.redireccion;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		return "home";
	}
	
	@RequestMapping(value = "/redireccionar", method = RequestMethod.GET)
	public String tratamientoRedireccion() {
		// codigo
		return "redirect:finalRedireccion";
	}
	
	@RequestMapping(value = "/finalRedireccion", method = RequestMethod.GET)
	public String metodoFinal() {
		// codigo
		return "redirect:/resources/inicio.html";
	}
}
