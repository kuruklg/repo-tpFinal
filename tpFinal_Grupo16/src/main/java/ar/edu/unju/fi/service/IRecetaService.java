package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Receta;


public interface IRecetaService {
	
	
	List<Receta> listarRecetas();
	
	
	String getCategoriaString(String categoria);
	
	
	void guardarReceta(Receta receta);
	
	
	void modificarReceta(Receta receta);
	
	
	void eliminarReceta(Long id);
	
	
	Receta getById(Long id);
	
	
	Receta getReceta();

}
