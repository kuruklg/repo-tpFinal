package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.repository.IIngredienteRepository;
import ar.edu.unju.fi.service.IIngredienteService;

@Service
public class IngredienteServiceImp implements IIngredienteService {
	
	@Autowired
	private IIngredienteRepository ingredienteRepository;
	
	@Autowired
	private Ingrediente ingrediente;
	
	
	@Override
	public List<Ingrediente> listarIngredientes() {
		return (List<Ingrediente>) ingredienteRepository.findAll();
	}

	@Override
	public void guardarIngrediente(Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);
	}

	@Override
	public void modificarIngrediente(Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);
	}

	@Override
	public void eliminarIngrediente(Long id) {
		ingredienteRepository.delete(ingrediente);
	}

	@Override
	public Ingrediente getById(Long id) {
		return ingredienteRepository.findById(id).get();
	}

	@Override
	public Ingrediente getIngrediente() {
		return ingrediente;
	}

}
