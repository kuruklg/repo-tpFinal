package ar.edu.unju.fi.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

@Controller
@RequestMapping("")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	
	@GetMapping("/registro")
	public String mostrarFormularioRegistro (Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registro";
	}
	
	@PostMapping("/registro")
	public ModelAndView guardarRegistro (@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model) {
		ModelAndView modelView = new ModelAndView("registro");
		
		if (result.hasErrors()) {
			modelView.setViewName("registro");
			modelView.addObject("usuario", usuario);
			return modelView;
		}
		
		/* Guardar el usuario en la base de datos */
		usuarioService.guardarUsuario(usuario);
		
		/* Obtener el identificador generado */
		Long idUsuario = usuario.getId();

		/* Asignar el rol "usuario normal" al usuario registrado */
	    usuario.setRolUsuario("normal");
	    usuarioService.guardarUsuario(usuario);
	    
		/* Agregar el identificador al modelo para mostrarlo en la vista */
		model.addAttribute("idUsuario", idUsuario);
		return modelView;
	}
	
	@GetMapping("/listado")
	public String getUsuariosListadoPage (Model model) {
		model.addAttribute("usuarios", usuarioService.listarUsuarios());
		return "gestion-usuarios";
	}
	
	@PostConstruct
	public void cargarUsuariosManualmente() {
	    /* Cargar usuario administrador manualmente */
	    LocalDate fechaActual = LocalDate.now();
	    Usuario administrador = new Usuario(1L, "admin", "admin", "admin@admin.com", fechaActual, "1234567890", "M", 180, "administrador");

	    /* Guardar los usuarios en la base de datos */
	    usuarioService.guardarUsuario(administrador);
	}
}
