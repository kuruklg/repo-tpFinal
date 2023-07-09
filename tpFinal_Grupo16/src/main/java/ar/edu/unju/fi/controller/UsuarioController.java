package ar.edu.unju.fi.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import jakarta.annotation.PostConstruct;

@Controller
public class UsuarioController {

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@GetMapping("/registro")
	public String mostrarFormularioRegistro (Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registro";
	}
	
	@PostMapping("/registro")
	public String procesarFormularioRegistro (@ModelAttribute Usuario usuario, Model model) {
		/* Guardar el usuario en la base de datos */
		usuarioRepository.save(usuario);
		
		/* Obtener el identificador generado */
		Long idUsuario = usuario.getId();
		
		/* Lógica adicional segun el rol del usuario
		
		if (esAdministrador(usuario)) {
			//acciones
		}else {
			//acciones
			
		}*/
		
		/* Asignar el rol "usuario normal" al usuario registrado */
	    usuario.setRolUsuario("normal");
	    usuarioRepository.save(usuario);
		
		/* Agregar el identificador al modelo para mostrarlo en la vista */
		model.addAttribute("idUsuario", idUsuario);
		return "registro";
	}
	
	@PostConstruct
	public void cargarUsuariosManualmente() {
	    /* Cargar usuario administrador manualmente */
	    LocalDate fechaActual = LocalDate.now();
	    Usuario administrador = new Usuario(1L, "admin", "admin", "admin@admin.com", fechaActual, "1234567890", "M", 180, "administrador");

	    /* Guardar los usuarios en la base de datos */
	    usuarioRepository.save(administrador);
	}
}
