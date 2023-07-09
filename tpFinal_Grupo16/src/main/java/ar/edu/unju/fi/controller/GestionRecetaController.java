package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.service.IIngredienteService;
import ar.edu.unju.fi.service.IRecetaService;

@Controller
@RequestMapping("/gestion-recetas")
public class GestionRecetaController {
	
	
	@Autowired
	private IRecetaService recetaService;
	
	@Autowired
	private IIngredienteService ingredienteService;
	
	
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
    
    
    @PostMapping("/guardar")
    public String guardarReceta(@ModelAttribute("receta")Receta receta, Model model) {
    	
    	recetaService.guardarReceta(receta);
    	model.addAttribute("recetas", recetaService.listarRecetas());
    	return "gestion-recetas";
    }
	
    
    @GetMapping("/nuevo-ingrediente")
    public String getNuevoIngredientePage(Model model) {
    	
    	model.addAttribute("ingrediente", ingredienteService.getIngrediente());
    	model.addAttribute("recetas", recetaService.listarRecetas());
    	return "nuevo-ingrediente";
    }
	
    
    @PostMapping("/guardar-ingrediente")
    public String guardarReceta(@ModelAttribute("ingrediente")Ingrediente ingrediente, Model model) {
    	
    	ingredienteService.guardarIngrediente(ingrediente);
    	model.addAttribute("recetas", recetaService.listarRecetas());
    	return "gestion-recetas";
    }
}
