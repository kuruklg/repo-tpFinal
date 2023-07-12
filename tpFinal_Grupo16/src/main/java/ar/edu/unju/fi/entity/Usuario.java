package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_id")
	private Long id;
	
	@Column(name = "nombre", nullable = false)
	@NotEmpty(message = "Debe ingresar su nombre")
	private String nombre;
	
	@Column(name = "apellido", nullable = false)
	@NotEmpty(message = "Debe ingresar su apellido")
	private String apellido;
	
	@Column(name = "email", nullable = false)
	@NotEmpty(message = "Debe ingresar su email")
	private String email;
	
	@Column(name = "fechaNacimiento", nullable = false)
	@NotNull(message = "Debe seleccionar su fecha de nacimiento")
	private LocalDate fechaNacimiento;
	
	@Column(name = "telefono", nullable = false)
	@NotEmpty(message = "Debe ingresar su numero de telefono")
	private String telefono;
	
	@Column(name = "sexo", nullable = false)
	@NotEmpty(message = "Debe seleccionar su sexo")
	private String sexo;
	
	@Column(name = "estatura", nullable = false)
	@Min(value = 1, message = "Debe ingresar su estatura")
	private int estatura;
	
	@Column(name = "rol_usuario")
	private String rolUsuario;
	
	@OneToMany(mappedBy="usuario")
	List<Testimonio> testimonios;
	
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
	
	public List<Testimonio> getTestimonios() {
		return testimonios;
	}
	
	public void setTestimonios(List<Testimonio> testimonios) {
		this.testimonios = testimonios;
	}
	
	public int calcularEdad() {
		LocalDate fechaHoy = LocalDate.now();
		
		Period periodo = Period.between(fechaHoy, fechaNacimiento);
	    int edad = Math.abs(periodo.getDays());
	    
		return edad;
	}
}
