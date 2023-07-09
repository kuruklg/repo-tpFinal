package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.repository.IRecetaRepository;
import ar.edu.unju.fi.service.IRecetaService;

@Service
public class RecetaServiceImp implements IRecetaService {
	
	
	@Autowired
	private IRecetaRepository recetaRepository;
	
	@Autowired
	private Receta receta;
	
	
	@Override
	public List<Receta> listarRecetas() {
		return (List<Receta>) recetaRepository.findByEstado(true);
	}


	@Override
	public String getCategoriaString(String categoria) {
		String cate = "";
		switch (categoria) {
		case "carnes":
			cate = "Carnes"; break;
		case "bebidas":
			cate = "Bebidas"; break;
		case "dulces":
			cate = "Dulces"; break;
		case "ensaladas":
			cate = "Ensaladas";	break;
		case "legumbresycereales":
			cate = "Legumbres y Cereales"; break;
		case "pescados":
			cate = "Pescados"; break;
		case "pan":
			cate = "Pan"; break;
		case "sopasycremas":
			cate = "Sopas y Cremas"; break;
		default:
			cate = "Carnes"; break;
		}
		return cate;
	}
	
	
	@Override
	public void guardarReceta(Receta receta) {
		receta.setEstado(true);
		recetaRepository.save(receta);
	}

	@Override
	public void modificarReceta(Receta receta) {
		recetaRepository.save(receta);
	}

	@Override
	public void eliminarReceta(Long id) {
		Receta receta = recetaRepository.findById(id).get();
		receta.setEstado(false);
		recetaRepository.save(receta);
	}

	@Override
	public Receta getById(Long id) {
		return recetaRepository.findById(id).get();
	}

	@Override
	public Receta getReceta() {
		return receta;
	}





}
