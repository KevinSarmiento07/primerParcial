package com.ufps.kass.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="paciente")
public class Paciente implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String documento;
	private String nombre;
	private String apellido;
	private String email;
	private String genero;
	
	@Column(name = "fechanacimiento")
	private Date fecha;
	private String telefono;
	private String direccion;
	private Double peso;
	private Double estatura;
	public Paciente(String documento, String nombre, String apellido, String email, String genero, Date fecha,
			String telefono, String direccion, Double peso, Double estatura) {
		
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.genero = genero;
		this.fecha = fecha;
		this.telefono = telefono;
		this.direccion = direccion;
		this.peso = peso;
		this.estatura = estatura;
	}

	
}
