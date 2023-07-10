package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.IUsuarioService;
import jakarta.validation.Valid;

@Service("usuarioServiceMysql")
public class UsuarioServiceImp implements IUsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	
	@Override
	public List<Usuario> listarUsuarios(){
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	@Override
	public void guardarUsuario(@Valid Usuario usuario) {
		usuarioRepository.save(usuario);
	}
}
