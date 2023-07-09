package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private LocalDate fechaNacimiento;
	private String telefono;
	private String sexo;
	private int estatura;
	private String rolUsuario;
	
	/** Crear una instancia de la clase usuario
	 * @param id un código que se genera automaticamente
	 * @param nombre corresponde al nombre del usuario
	 * @param apellido corresponde al apellido del usuario
	 * @param email corresponde al email del usuario
	 * @param fechaNacimiento corresponde a la fecha de nacimiento del usuario
	 * @param telefono corresponde al telefono del usuario
	 * @param sexo corresponde al sexo del usuario
	 * @param estatura corresponde a la estatura del usuario
	 */
	public Usuario(Long id, String nombre, String apellido, String email, LocalDate fechaNacimiento, String telefono,
			String sexo, int estatura, String rolUsuario) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.sexo = sexo;
		this.estatura = estatura;
		this.rolUsuario = rolUsuario;
	}

	/**
	 * 
	 */
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
/* Getters and Setters*/
	
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getEstatura() {
		return estatura;
	}

	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}
	
	// Métodos adicionales para usuarios creados manualmente
    public void setIdManual(Long id) {
        this.id = id;
    }

    public Long getIdManual() {
        return id;
    }

	public String getRolUsuario() {
		return rolUsuario;
	}

	public void setRolUsuario(String rolUsuario) {
		this.rolUsuario = rolUsuario;
	}
}
