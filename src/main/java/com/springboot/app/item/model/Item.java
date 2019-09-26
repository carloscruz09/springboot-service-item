package com.springboot.app.item.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

	private Producto producto;
	private Integer cantidad;

	public Item() {

	}

	/**
	 * @param producto
	 * @param cantidad
	 */
	public Item(Producto producto, Integer cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Double getTotal() {
		return producto.getPrecio() * cantidad.doubleValue();
	}
}
