package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;

public interface IIndiceIMCService {
	
	
	List<IndiceMasaCorporal> listarImc();
	
	
	void guardarImc(IndiceMasaCorporal imc);
	
	
	void modificarImc(IndiceMasaCorporal imc);

	
	void eliminarImc(Long id);
	
	
	IndiceMasaCorporal getById(Long id);
	
	
	IndiceMasaCorporal getIMC();
	
	
	String calcularImc(int estatura, float peso);
}
