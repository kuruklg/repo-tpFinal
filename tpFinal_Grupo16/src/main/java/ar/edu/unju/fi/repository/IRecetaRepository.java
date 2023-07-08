package ar.edu.unju.fi.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.entity.Receta;

//@Repository
public interface IRecetaRepository extends JpaRepository<Receta, Long> {
	
	//public List<Receta> findByEstado(boolean estado);
}
