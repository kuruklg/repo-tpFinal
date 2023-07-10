package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.IUsuarioService;

@Controller
@RequestMapping("/gestion-usuarios")
public class GestionUsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	/** Ir a la pagina de gestion de datos
	 * 
	 * @return renderiza el la pag de gestion de datos
	 */
    @GetMapping("")
    public String getGestionPage(Model model) {
    	model.addAttribute("usuarios", usuarioService.listarUsuarios());
    	return "gestion-usuarios";
    }
}
