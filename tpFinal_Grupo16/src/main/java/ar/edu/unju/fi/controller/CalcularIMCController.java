package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/servicio/calcular-IMC")
public class CalcularIMCController {
	
	
	/** Ir a la pagina de servicio de calcular imc
	 * 
	 * @return renderiza el la pag del servicio de calcular el imc
	 */
    @GetMapping("")
    public String getServicioCalcularIMCsPage(Model model) {
        return "redirect:/servicio/calcular-IMC/listado";
    }
	
	
	
	/** Ir a la pagina de testimonios
	 * 
	 * @return renderiza el la pag con el listado de testimonios
	 */
    @GetMapping("/listado")
    public String getServicioCalcularIMCListadoPage(Model model) {
        return "servicio-calcularimc";
    }
	
}
