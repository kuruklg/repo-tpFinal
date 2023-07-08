package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/servicio/peso-ideal")
public class PesoIdealController {
	
	
	
	/** Ir a la pagina de servicio de peso ideal
	 * 
	 * @return renderiza el la pag del servicio de peso ideal
	 */
    @GetMapping("")
    public String getServicioPesoIdealPage(Model model) {
        return "redirect:/servicio/peso-ideal/listado";
    }
	
	
	
	/** Ir a la pagina de peso ideal
	 * 
	 * @return renderiza el la pag con el listado de peso ideal
	 */
    @GetMapping("/listado")
    public String getServicioPesoIdealListadoPage(Model model) {
        return "servicio-pesoideal";
    }
	
}
