package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.repository.IIndiceIMCRepository;
import ar.edu.unju.fi.service.IIndiceIMCService;

@Service("indiceMasaCorporalService")
public class IndiceIMCImp implements IIndiceIMCService {
	
	@Autowired
	private IIndiceIMCRepository imcRepository;
	
	@Autowired
	private IndiceMasaCorporal imc;
	
	
	@Override
	public List<IndiceMasaCorporal> listarImc() {
		return imcRepository.findByEstado(true);
	}

	@Override
	public void guardarImc(IndiceMasaCorporal imc) {
		imc.setEstado(true);
		imcRepository.save(imc);
	}

	@Override
	public void modificarImc(IndiceMasaCorporal imc) {
		imcRepository.save(imc);
	}

	@Override
	public void eliminarImc(Long id) {
		IndiceMasaCorporal imc = imcRepository.findById(id).get();
		imc.setEstado(false);
		imcRepository.save(imc);
	}

	@Override
	public IndiceMasaCorporal getById(Long id) {
		return imcRepository.findById(id).get();
	}

	@Override
	public IndiceMasaCorporal getIMC() {
		return imc;
	}

	@Override
	public String calcularImc(int estatura, float peso) {
		String resp = "";
		float imc = peso / (estatura*2);
		if(imc>=18.5 && imc<=25) {
			resp = "Está en su peso ideal";
		} else if(imc<18.5) {
			resp = "Está por debajo de su peso ideal";
		} else {
			resp = "Tiene sobrepeso";
		}
		return resp;
	}

}
