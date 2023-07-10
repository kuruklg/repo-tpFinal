package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Testimonio;

public interface ITestimonioService {
	
	
	List<Testimonio> listarTestimonio();
	
	
	void guardarTestimonio(Testimonio Testimonio);
	
	
	void modificarTestimonio(Testimonio Testimonio);
	
	
	void eliminarTestimonio(Long id);
	
	
	Testimonio getById(Long id);
	
	
	Testimonio getTestimonio();

}
