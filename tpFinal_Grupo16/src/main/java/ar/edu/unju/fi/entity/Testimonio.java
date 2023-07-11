package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name="testimonios")
public class Testimonio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tes_id")
	private Long id;
	
	@Column(name = "tes_fecha")
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	@Column(name = "tes_comentario")
	@Size(min=5, message="el comentario debe contener al menos 5 caracteres.")
	private String comentario;
	
	@ManyToOne()
	@JoinColumn(name="usu_id")
	@NotNull(message = "Debe seleccionar un ID")
	private Usuario usuario;
	
	@Column(name = "tes_estado")
	private boolean estado;
	
	public Testimonio() {
		// TODO Auto-generated constructor stub
	}

	public Testimonio(LocalDate fecha, String comentario, Usuario usuario) {
		super();
		this.fecha = fecha;
		this.comentario = comentario;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
