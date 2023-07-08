package ar.edu.unju.fi.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "recetas")
public class Receta {
	
	@Id
	@Column(name = "rec_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "rec_nombre", nullable = false)
	private String nombre;
	
	@Column(name = "rec_categoria", nullable = false)
	private String categoria;
	
	@OneToMany(mappedBy = "receta")
	private List<Ingrediente> ingredientes;
	
	@Column(name = "rec_preparacion", nullable = false)
	private String preparacion;
	
	@Column(name = "rec_imagen", nullable = false)
	private String imagen;
	
	@Column(name = "rec_estado", nullable = false)
	private boolean estado;
	
	
	// contructor por defecto
	public Receta() {}

	
	// contructor sobrecargado
	public Receta(Long id, String nombre, String categoria, String preparacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.preparacion = preparacion;
	}
	
	
	// getters and setters
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}


	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
