package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.repository.IRecetaRepository;


public interface IRecetaService {
	
	
	List<Receta> listarRecetas();
	
	
	void guardarReceta(Receta receta);
	
	
	void modificarReceta(Receta receta);
	
	
	void eliminarReceta(Long id);
	
	
	Receta getById(Long id);
	
	
	Receta getReceta();

}
