package com;

public class Producto {
	
	private static int id = 0;
	private String nombre;
	private String descripcion;
	private Integer peso;
	private Integer stock;

	Producto(){
		
	}
	
	Producto(String nombre, String descripcion, Integer peso, Integer stock){
		setNombre(nombre);
		setDescripcion(descripcion);
		setPeso(peso);
		setStock(stock);
		id++;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
	
}
