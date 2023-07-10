package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Contacto;

@Component
public class ListaMensajes {

	private List<Contacto> mensajes;
	
	public ListaMensajes() {
		mensajes = new ArrayList<Contacto>();
	}

	public List<Contacto> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Contacto> mensajes) {
		this.mensajes = mensajes;
	}

}
