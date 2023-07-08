package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testimonios")
public class TestimonioController {

	
	/** Ir a la pagina de testimonios
	 * 
	 * @return renderiza el la pag con el listado de testimonios
	 */
    @GetMapping("")
    public String getTestimoniosPage(Model model) {
        return "redirect:/testimonios/listado";
    }
	
	
	
	/** Ir a la pagina de testimonios
	 * 
	 * @return renderiza el la pag con el listado de testimonios
	 */
    @GetMapping("/listado")
    public String getTestimoniosListadoPage(Model model) {
        return "testimonios";
    }
}
