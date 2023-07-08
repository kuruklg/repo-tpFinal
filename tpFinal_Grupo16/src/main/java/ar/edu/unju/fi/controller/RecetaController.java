package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recetas")
public class RecetaController {
	
	
	/** Ir a la pagina de recetas
	 * 
	 * @return renderiza el la pag con el listado de recetas
	 */
    @GetMapping("")
    public String getRecetasPage(Model model) {
        return "redirect:/recetas/listado";
    }
	
	
	/**
	 * Redirecciona a la página "receta"
	 * 
	 * @return La vista de la página "receta"
	 */
	@GetMapping("/listado")
	public String getRecetasListadoPage() {
		return "recetas";
	}
}
