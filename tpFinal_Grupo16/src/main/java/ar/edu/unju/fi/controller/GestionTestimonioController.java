package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.ITestimonioService;

@Controller
@RequestMapping("/gestion-testimonios")
public class GestionTestimonioController {
	@Autowired
	private ITestimonioService testimonioService;
	
	/** Ir a la pagina de gestion de datos
	 * 
	 * @return renderiza el la pag de gestion de datos
	 */
    @GetMapping("")
    public String getGestionPage(Model model) {
    	model.addAttribute("testimonios", testimonioService.listarTestimonio());
    	return "gestion-testimonios";
    }
    
    @GetMapping("/modificar")
    public String getModificarPage(Model model) {
    	model.addAttribute("testimonios", testimonioService.listarTestimonio());
    	return "gestion-testimonios";
    }
    
	@GetMapping("/eliminar/{id}")
	public String deleteProductoPage(@PathVariable("id")Long id) {
    	testimonioService.eliminarTestimonio(id);
    	return "redirect:/gestion-testimonios";
	}
}
