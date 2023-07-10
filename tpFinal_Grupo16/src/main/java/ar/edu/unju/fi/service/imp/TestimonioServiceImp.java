package ar.edu.unju.fi.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.repository.ITestimonioRepository;
import ar.edu.unju.fi.service.ITestimonioService;

@Service
public class TestimonioServiceImp implements ITestimonioService {
	@Autowired
	private ITestimonioRepository testimonioRepository;
	
	@Autowired
	private Testimonio testimonio;
	
	
	@Override
	public List<Testimonio> listarTestimonio() {
		return (List<Testimonio>) testimonioRepository.findByEstado(true);
	}

	@Override
	public void guardarTestimonio(Testimonio testimonio) {
		LocalDate date = LocalDate.now();
		testimonio.setEstado(true);
		testimonio.setFecha(date);
		testimonioRepository.save(testimonio);
	}

	@Override
	public void modificarTestimonio(Testimonio testimonio) {
		testimonioRepository.save(testimonio);
	}

	@Override
	public void eliminarTestimonio(Long id) {
		Testimonio testimonio = testimonioRepository.findById(id).get();
		testimonio.setEstado(false);
		testimonioRepository.save(testimonio);
	}

	@Override
	public Testimonio getById(Long id) {
		return testimonioRepository.findById(id).get();
	}

	@Override
	public Testimonio getTestimonio() {
		return testimonio;
	}

}
