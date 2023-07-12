package ar.edu.unju.fi.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Component
@Entity
@Table(name = "recetas")
public class Receta {
	
	@Id
	@Column(name = "rec_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "rec_nombre", nullable = false)
	@NotEmpty(message = "Debe ingresar un nombre para la receta")
	private String nombre;
	
	@Column(name = "rec_categoria", nullable = false)
	@NotEmpty(message = "Debe ingresar una categoria")
	private String categoria;
	
//	@OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	
	@OneToMany(mappedBy = "receta")
	private List<Ingrediente> ingredientes;
	
	@Column(name = "rec_preparacion", nullable = false)
	@NotEmpty(message = "Debe ingresar la preparacion")
	private String preparacion;
	
	@Column(name = "rec_imagen", nullable = false)
	@NotEmpty(message = "Debe ingresar el url de una imagen")
	private String imagen;
	
	@Column(name = "rec_estado", nullable = false)
	private boolean estado;
	
	
	// contructor por defecto
	public Receta() {}

	
	// contructor sobrecargado
	public Receta(Long id, String nombre, String categoria, String preparacion, String imagen, boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.preparacion = preparacion;
		this.imagen = imagen;
		this.estado = estado;
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
