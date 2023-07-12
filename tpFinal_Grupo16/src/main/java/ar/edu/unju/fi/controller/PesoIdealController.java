package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.entity.PesoIdeal;
import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.service.IPesoIdealService;
import ar.edu.unju.fi.service.IUsuarioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicio/calcular-peso-ideal")
public class PesoIdealController {
	
	@Autowired
	private IPesoIdealService pesoIdealService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	/** Ir a la pagina de servicio de peso ideal
	 * 
	 * @return renderiza el la pag del servicio de peso ideal
	 */
    @GetMapping("")
    public String getServicioPesoIdealPage(Model model) {
        return "redirect:/servicio/peso-ideal/formulario";
    }
	
	
	
	/** Ir a la pagina de peso ideal
	 * 
	 * @return renderiza el la pag con el listado de peso ideal
	 */
    @GetMapping("/formulario")
    public String getServicioPesoIdealListadoPage(Model model) {
    	model.addAttribute("pesoIdeal", pesoIdealService.getPesoIdeal());
		model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "servicio-pesoideal";
    }
    
    @PostMapping("/guardar")
	public String guardarPesoIdeal(@Valid @ModelAttribute("pesoIdeal")PesoIdeal pesoIdeal, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("pesoIdeal", pesoIdeal);
			model.addAttribute("usuarios", usuarioService.listarUsuarios());
			return "servicio-pesoideal";
		} else {
			pesoIdealService.calcularPesoIdeal(pesoIdeal);
			model.addAttribute("pesoIdeal", pesoIdeal);
			model.addAttribute("usuarios", usuarioService.listarUsuarios());
			return "servicio-pesoideal";
		}
	}
}
