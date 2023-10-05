package com.model;

public class Producto {

	private Long id;
	private String nombre;
	private String descripcion;
	private Float peso;
	private Integer stock;
	
	public Producto() {
		
	}
	
	public Producto(Long id, String nombre, String descripcion, Float peso, Integer stock) {
		setNombre(nombre);
		setDescripcion(descripcion);
		setPeso(peso);
		setStock(stock);
		setId(id);
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
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Producto [getNombre()=" + getNombre() + ", getDescripcion()=" + getDescripcion() + ", getPeso()="
				+ getPeso() + ", getStock()=" + getStock() + ", getId()=" + getId() + "]";
	}

	
	
	
	
	
}
