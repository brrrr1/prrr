package com.salesianostriana.dam.pruebaproyecto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor 
@Entity @Builder
public class Usuario {
	
	@Id @GeneratedValue
	private long id;
	private String nombre;
	private String apellido;
	private String dni;
	private String email;
	private String contrasenia;

}
