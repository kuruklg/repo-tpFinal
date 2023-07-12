package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotNull;

/** Clase ingrediente
 * 
 * @author grupo 16
 *
 */
@Component
@Entity
@Table(name = "ingredientes")
public class Ingrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ing_id", nullable = false)
	private Long id;
	
	@Column(name = "ing_nombre", nullable = false)
	private String nombre;
	
	/* Relacion muchos a uno */
	@ManyToOne()
	@JoinColumn(name = "rec_id")
	@NotNull(message = "Debe seleccionar una receta")
	private Receta receta;
	
	public Ingrediente() {}

	public Ingrediente(Long id, String nombre, Receta receta) {
		this.id = id;
		this.nombre = nombre;
		this.receta = receta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}
	
	
	
}
