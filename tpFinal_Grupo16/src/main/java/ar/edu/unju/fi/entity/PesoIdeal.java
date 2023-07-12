package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotNull;

@Component
public class PesoIdeal {	
	
	@NotNull(message = "Debe seleccionar un ID")
	private Usuario usuario;
	
	private double pesoCalculado;
	
	public PesoIdeal() {
		// TODO Auto-generated constructor stub
	}

	public PesoIdeal(Usuario usuario) {
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
