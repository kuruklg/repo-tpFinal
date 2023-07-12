package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;

@Repository
public interface IIndiceIMCRepository extends CrudRepository<IndiceMasaCorporal, Long> {
	
	
	List<IndiceMasaCorporal> findByEstado(boolean estado);
	

	
}
