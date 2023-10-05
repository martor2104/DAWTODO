package com.dao;

import java.util.List;

import com.model.Producto;

public interface ProductoServicio {
	Boolean createProducto(Producto producto);
	Producto readProducto(Long id);
	Boolean updateProducto(Producto producto);
	Boolean deleteProducto(Long id);
}
