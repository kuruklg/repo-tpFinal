package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.PesoIdeal;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IPesoIdealService;

@Service
public class PesoIdealServiceImp implements IPesoIdealService {
	
	@Autowired
	PesoIdeal pesoIdeal;
	
	@Override
	public void calcularPesoIdeal(PesoIdeal pesoIdeal) {
		Usuario usuario = pesoIdeal.getUsuario();
		int edad = usuario.calcularEdad();
		int altura = usuario.getEstatura();
		double calculo = altura - 100 + ((edad/10) * 0.9); 
		pesoIdeal.setPesoCalculado(calculo);
	}
	
	@Override
	public PesoIdeal getPesoIdeal() {
		return pesoIdeal;
	}
}
