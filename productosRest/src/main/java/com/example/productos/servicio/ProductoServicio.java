package com.example.productos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productos.modelo.Producto;
import com.example.productos.repositorio.ProductoRepositorio;

@Service
public class ProductoServicio {
	
	@Autowired
	private ProductoRepositorio productoRepositorio; //interfaces
	
	public List<Producto> listarProductos(){
		
		return productoRepositorio.findAll();
	}
	
	
	public void guardarProducto(Producto producto) {
		
		productoRepositorio.save(producto);
		
	}
	
	public Producto obtenerProductoPorId(Integer id) {
		
		return  productoRepositorio.findById(id).get();
	}
	
	public void eliminarProducto(Integer id) {
		
		productoRepositorio.deleteById(id);
		
		
		
	}

}
