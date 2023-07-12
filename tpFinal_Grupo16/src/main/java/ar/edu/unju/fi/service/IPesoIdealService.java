package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.PesoIdeal;
import ar.edu.unju.fi.entity.Usuario;

public interface IPesoIdealService {
	
	
	void calcularPesoIdeal(PesoIdeal pesoIdeal);
	
	
	PesoIdeal getPesoIdeal();
}
