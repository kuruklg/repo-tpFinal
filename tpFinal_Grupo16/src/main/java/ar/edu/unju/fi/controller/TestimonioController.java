package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.service.ITestimonioService;
import ar.edu.unju.fi.service.IUsuarioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/testimonios")
public class TestimonioController {

	
	@Autowired
	private ITestimonioService testimonioService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
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
		model.addAttribute("testimonios", testimonioService.listarTestimonio());
        return "testimonios";
    }
    
	@GetMapping("/nuevo")
	public String getNuevoTestimonioPage(Model model) {
		model.addAttribute("testimonios", testimonioService.getTestimonio());
		model.addAttribute("usuarios", usuarioService.listarUsuarios());
		return "nuevo-testimonio";
	}
	
	/** Controlador para procesar el envío del formulario de nuevo testimonio
	 * 
	 * @param testimonio
	 * @param result
	 * @param model
	 * @return retorna la pagina de nuevo-testimonio en caso de salir algun error de validacion
	 * @return renderiza la pagina testimonios y carga su lista en caso de que se haya agregado datos validos
	 */
	@PostMapping("/guardar")
	public String guardarTestimonio(@Valid @ModelAttribute("testimonios")Testimonio testimonio, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("testimonios", testimonio);
			return "nuevo-testimonio";
		} else {
			testimonioService.guardarTestimonio(testimonio);
			model.addAttribute("usuarios", usuarioService.listarUsuarios());
			return "redirect:/testimonios";
		}
	}
}
