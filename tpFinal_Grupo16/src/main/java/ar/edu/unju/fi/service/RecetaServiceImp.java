package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.repository.IRecetaRepository;

@Service
public class RecetaServiceImp {
	
	@Autowired
	private IRecetaRepository recetaRepository;
	
	public List<Receta> listarRecetas() {
		return recetaRepository.findAll();
	}
	
	public void guardarReceta(Receta receta) {
		recetaRepository.save(receta);
	}
	
	public void modificarReceta(Receta receta) {
		recetaRepository.save(receta);
	}

	public Receta obtenerRecetaPorId(Long id) {
		return recetaRepository.findById(id).get();
	}
	
	public void eliminarReceta(Long id) {
		recetaRepository.deleteById(id);
	}
}
