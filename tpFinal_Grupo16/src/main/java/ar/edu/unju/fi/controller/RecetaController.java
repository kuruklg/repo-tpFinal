package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.service.IIngredienteService;
import ar.edu.unju.fi.service.IRecetaService;

@Controller
@RequestMapping("/recetas")
public class RecetaController {
	
	@Autowired
	private IRecetaService recetasService;
	
	@Autowired
	private IIngredienteService ingredienteService;
	
	
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
	public String getRecetasListadoPage(Model model) {
		
		model.addAttribute("recetas", recetasService.listarRecetas());
		return "recetas";
	}
	
	
	@GetMapping("listado/{id}")
	public String getVerRecetaPage(@PathVariable("id")Long id, Model model) {
		
		Receta receta = recetasService.getById(id);
		model.addAttribute("receta", receta);
		model.addAttribute("idreceta", id);
		model.addAttribute("ingredientes", ingredienteService.listarIngredientes());
		return "ingredientes";
	}
	
	
	@GetMapping("listado/categoria/{categoria}")
	public String getVerRecetaPage(@PathVariable("categoria")String categoria, Model model) {
		System.out.println("entraste a la categoria: " + categoria);
		String cate = recetasService.getCategoriaString(categoria);
		model.addAttribute("recetas", recetasService.listarRecetas());
		model.addAttribute("categoria", cate);
		return "receta-por-categoria";
	}
	
	
}



