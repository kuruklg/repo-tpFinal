package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gestion")
public class GestionController {

	
	
	/** Ir a la pagina de gestion de datos
	 * 
	 * @return renderiza el la pag de gestion de datos
	 */
    @GetMapping("")
    public String getGestionPage(Model model) {
        return "gestion";
    }
	
	
}
