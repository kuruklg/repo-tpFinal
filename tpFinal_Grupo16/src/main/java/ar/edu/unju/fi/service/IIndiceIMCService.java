package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;

public interface IIndiceIMCService {
	
	
	List<IndiceMasaCorporal> listarImc();
	
	
	List<IndiceMasaCorporal> listarPorFechaImcById(Long id);
	
	
	void guardarImc(IndiceMasaCorporal imc);
	
	
	void modificarImc(IndiceMasaCorporal imc);

	
	void eliminarImc(Long id);
	
	
	IndiceMasaCorporal getById(Long id);
	
	
	IndiceMasaCorporal getIMC();
	
	
	float calcularImc(int estatura, float peso);
	
	
	String calcularImcMsg(int estatura, float peso);
}
