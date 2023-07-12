package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "indiceMasaCorporal")
public class IndiceMasaCorporal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ind_id")
	private Long id;	
	
	@Column(name = "ind_fechaimc", nullable = false)
	private LocalDate fechaimc;
	
	@ManyToOne
	@JoinColumn(name = "usu_id")
	private Usuario usuario;
	
	
	@Column(name = "ind_estado", nullable = false)
	private boolean estado;
	
	@Column(name = "ind_peso")
	private int peso;
	
	@Column(name = "ind-imc")
	private float imc;
	


	public IndiceMasaCorporal() {}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDate getFechaimc() {
		return fechaimc;
	}


	public void setFechaimc(LocalDate fechaimc) {
		this.fechaimc = fechaimc;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;
	}


	public float getImc() {
		return imc;
	}


	public void setImc(float imc) {
		this.imc = imc;
	}
	
	
}
