package com.example.productos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productos.modelo.Producto;
import com.example.productos.servicio.ProductoServicio;

@RestController

public class ProductoControlador {
	
	@Autowired
	private ProductoServicio productoServicio;
	
	@GetMapping({"/productos",""})
	public List<Producto> listarProductos(){
		
		
		
		return productoServicio.listarProductos();
		
	}
	
	@GetMapping("/productos/{id}")
	
	public  ResponseEntity<Producto>obtenerProducto(@PathVariable Integer id) {
	
		// para mandar un mensaje si no se encontro el id en la base de datos
		try {
		 Producto producto =  productoServicio.obtenerProductoPorId(id);	 
		 
		 return new ResponseEntity<Producto>(producto,HttpStatus.OK);
		 
		
		} catch (Exception e) {
			// TODO: handle exception
			
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
		
		
		//return productoServicio.obtenerProductoPorId(id);
	}
	
	@PostMapping("/productos")
	public void guardarProducto(@RequestBody Producto producto){
		
		productoServicio.guardarProducto(producto);
			
		
	}
	
	
	@PutMapping("/productos/{id}")
public ResponseEntity<?>actualizarProducto(@RequestBody Producto producto,@PathVariable Integer id) { 
					
			// para mandar un mensaje si no se encontro el id en la base de datos
			try {
			 Producto productoActual =  productoServicio.obtenerProductoPorId(id);
			 productoActual.setNombre(producto.getNombre());
			 productoActual.setPrecio(producto.getPrecio());
			 
			 
			 productoServicio.guardarProducto(productoActual);
			 
			 return new ResponseEntity<Producto>(HttpStatus.OK);
			 
			
			} catch (Exception e) {
				// TODO: handle exception
				
				return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
			}
		
		
		
	}
	
	
	@DeleteMapping("/productos/{id}")
	public void eliminarProducto(@PathVariable Integer id) {
		
		productoServicio.eliminarProducto(id);
	}
	
	
	

}
