package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.IRecetaService;

@Controller
@RequestMapping("/gestion-recetas")
public class GestionRecetaController {
	
	
	@Autowired
	private IRecetaService recetaService;
	
	
	/** Ir a la pagina de gestion de datos
	 * 
	 * @return renderiza el la pag de gestion de datos
	 */
    @GetMapping("")
    public String getGestionPage(Model model) {
    	
    	model.addAttribute("recetas", recetaService.listarRecetas());
        return "gestion-recetas";
    }
    
    @GetMapping("/nuevo")
    public String getNuevaRecetaPage(Model model) {
    	
    	model.addAttribute("receta", recetaService.getReceta());
    	return "nueva-receta";
    }
	
	
}
