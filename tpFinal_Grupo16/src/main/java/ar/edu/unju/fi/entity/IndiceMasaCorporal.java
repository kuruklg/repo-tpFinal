package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "indiceIMC")
public class IndiceMasaCorporal {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ind_id")
	private Long id;
	
	@Column(name = "ind_fecha", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaImc;
	
	@Column(name = "ind_usu")
	private Usuario usuraio;
	
	@Column(name = "ind_estado")
	private boolean estado;
	
	/** Constructor por defecto
	 * 
	 */
	public IndiceMasaCorporal() {}

	/** Contructor sobrecargado
	 * 
	 * @param id
	 * @param fechaImc
	 * @param usuraio
	 * @param estado
	 */
	public IndiceMasaCorporal(Long id, LocalDate fechaImc, Usuario usuraio, boolean estado) {
		this.id = id;
		this.fechaImc = fechaImc;
		this.usuraio = usuraio;
		this.estado = estado;
	}
	
		
	/* getter and setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaImc() {
		return fechaImc;
	}

	public void setFechaImc(LocalDate fechaImc) {
		this.fechaImc = fechaImc;
	}

	public Usuario getUsuraio() {
		return usuraio;
	}

	public void setUsuraio(Usuario usuraio) {
		this.usuraio = usuraio;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}






