package com.hibernate.entities;

import javax.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "barcos")
public class Barco {
	@Id
	@NotBlank(message = "La matrícula no puede estar vacía")
	@Pattern(regexp = "^[A-Za-z0-9]{10}$", message = "La matrícula debe tener 10 caracteres alfanuméricos")
	@Column(name = "matricula", unique = true, nullable = false)
	private String matricula;

	@NotBlank(message = "El nombre no puede estar vacío")
	@Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
	@Column(name = "nombre", nullable = false)
	private String nombre;

	@NotNull(message = "El número de amarre no puede ser nulo")
	@Min(value = 1, message = "El número de amarre debe ser mayor que 0")
	@Column(name = "numero_amarre", nullable = false)
	private Integer numeroAmarre;

	@NotNull(message = "La cuota no puede ser nula")
	@DecimalMin(value = "0.0", inclusive = false, message = "La cuota debe ser mayor que 0")
	@Column(name = "cuota", nullable = false)
	private Double cuota;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "socio_id", nullable = false)
	private Socio socio;

	@OneToMany(mappedBy = "barco", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Salida> salidas;

	// Constructores, getters y setters
	public Barco() {
	}

	public Barco(String matricula, String nombre, Integer numeroAmarre, Double cuota, Socio socio) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.numeroAmarre = numeroAmarre;
		this.cuota = cuota;
		this.socio = socio;
	}

	// Getters y setters para todos los campos

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumeroAmarre() {
		return numeroAmarre;
	}

	public void setNumeroAmarre(Integer numeroAmarre) {
		this.numeroAmarre = numeroAmarre;
	}

	public Double getCuota() {
		return cuota;
	}

	public void setCuota(Double cuota) {
		this.cuota = cuota;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public List<Salida> getSalidas() {
		return salidas;
	}

	public void setSalidas(List<Salida> salidas) {
		this.salidas = salidas;
	}

}
