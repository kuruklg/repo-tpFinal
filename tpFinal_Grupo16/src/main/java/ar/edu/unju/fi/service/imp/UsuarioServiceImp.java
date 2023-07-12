package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.IIndiceIMCService;
import ar.edu.unju.fi.service.IUsuarioService;
import jakarta.validation.Valid;

@Service("usuarioService")
public class UsuarioServiceImp implements IUsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private Usuario usuario;
	
	@Override
	public List<Usuario> listarUsuarios(){
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	@Override
	public void guardarUsuario(@Valid Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public boolean login(Long id) {
		boolean existe = false;
		List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
		for(Usuario usu : usuarios) {
			if(usu.getId() == id) {
				existe = true;
			}
		}
		return existe;
	}

	@Override
	public Usuario getUsuario() {
		return usuario;
	}

	@Override
	public Usuario getById(Long id) {
		return usuarioRepository.findById(id).get();
	}
	
}
