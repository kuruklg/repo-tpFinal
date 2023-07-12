package ar.edu.unju.fi.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IIndiceIMCService;
import ar.edu.unju.fi.service.IUsuarioService;

@Controller
@RequestMapping("/servicio/calcular-IMC")
public class CalcularIMCController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IIndiceIMCService imcService;
	
    Usuario usuarioLogeado;
	
	/** Ir a la pagina de servicio de calcular imc
	 * 
	 * @return renderiza el la pag del servicio de calcular el imc
	 */
    @GetMapping("")
    public String getServicioCalcularIMCsPage(Model model) {
        model.addAttribute("variable", false);
        model.addAttribute("usuario", usuarioService.getUsuario());
        model.addAttribute("imc", imcService.getIMC());
    	return "servicio-calcularimc";
    }
	
	
	
	/** Ir a la pagina de testimonios
	 * 
	 * @return renderiza el la pag con el listado de testimonios
	 */
    @GetMapping("/listado")
    public String getServicioCalcularIMCListadoPage(Model model) {
        return "servicio-calcularimc";
    }
    

    
	@PostMapping("/login")
	public String loginUsuario(@ModelAttribute("usuario")Usuario usuario, Model model) {
		boolean existe = usuarioService.login(usuario.getId());
		if(existe == true) {
			usuarioLogeado = usuarioService.getById(usuario.getId());
			model.addAttribute("idUsuario", usuarioLogeado.getId());
			model.addAttribute("nameUsuario", usuarioLogeado.getNombre());
			model.addAttribute("estaturaUsuario", usuarioLogeado.getEstatura());
//			model.addAttribute("user", usuarioService.getById(usuario.getId()));
//			model.addAttribute("usuario", usuarioService.getUsuario());
			model.addAttribute("imc", imcService.getIMC());
			model.addAttribute("variable", true);
			model.addAttribute("mostrarRes", false);
			return "servicio-calcularimc";
		} else {
			model.addAttribute("usuario", usuarioService.getUsuario());
			model.addAttribute("variable", false);
			model.addAttribute("imc", imcService.getIMC());
			model.addAttribute("idUsuario", usuario.getId());
			return "servicio-calcularimc";
		}
	}
    
    
    
    @PostMapping("/calculo")
    public String calcularImc(@ModelAttribute("imc")IndiceMasaCorporal imc, Model model) {
    	String resultado = imcService.calcularImc(usuarioLogeado.getEstatura(), imc.getPeso());
    	imc.setFechaimc(LocalDate.now());
    	imcService.guardarImc(imc);
    	
    	model.addAttribute("usuario", usuarioLogeado);
    	model.addAttribute("idUsuario", usuarioLogeado.getId());
		model.addAttribute("nameUsuario", usuarioLogeado.getNombre());
		model.addAttribute("estaturaUsuario", usuarioLogeado.getEstatura());
    	model.addAttribute("resultado", resultado);
    	model.addAttribute("mostrarRes", true);
		model.addAttribute("variable", true);
    	model.addAttribute("imc", imcService.getIMC());
    	return "servicio-calcularimc"; 
    }
    
    
    
    
	
}
