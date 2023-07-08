package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacto")
public class ContactoController {

	
	/** Ir a la pagina de contacto
	 * 
	 * @return renderiza el la pag del servicio de contacto
	 */
    @GetMapping("")
    public String getContactoPage(Model model) {
        return "contacto";
    }
	

}
