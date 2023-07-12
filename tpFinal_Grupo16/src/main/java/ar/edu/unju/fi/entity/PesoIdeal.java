package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Component
public class PesoIdeal {	
	
	private Usuario usuario;
	
	private double pesoCalculado;
	
	public PesoIdeal() {
		// TODO Auto-generated constructor stub
	}

	public PesoIdeal(@NotNull(message = "Debe seleccionar un ID") Usuario usuario) {
		this.usuario = usuario;
	}

	public double getPesoCalculado() {
		return pesoCalculado;
	}
	
	public void setPesoCalculado(double pesoCalculado) {
		this.pesoCalculado = pesoCalculado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
