package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Ingrediente;

public interface IIngredienteService {
	
	List<Ingrediente> listarIngredientes();
	
	
	void guardarIngrediente(Ingrediente ingrediente);
	
	
	void modificarIngrediente(Ingrediente ingrediente);
	
	
	void eliminarIngrediente(Long id);
	
	
	Ingrediente getById(Long id);
	
	
	Ingrediente getIngrediente();
	
}
