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
	
	@Column(name = "sucu_fechaInauguracion", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaImc;
	
	
	
	
	
}






