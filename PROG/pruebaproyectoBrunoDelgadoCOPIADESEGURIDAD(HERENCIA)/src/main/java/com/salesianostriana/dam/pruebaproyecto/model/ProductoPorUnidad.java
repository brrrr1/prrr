package com.salesianostriana.dam.pruebaproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ProductoPorUnidad extends Producto {

	private int stock;

	public ProductoPorUnidad(long id, String nombre, String descripcion, int likes, String foto, double precio,
			int stock) {
		super(id, nombre, descripcion, likes, foto, precio);
		this.stock = stock;
	}

}