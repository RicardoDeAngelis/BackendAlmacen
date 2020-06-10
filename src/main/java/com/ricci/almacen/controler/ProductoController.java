package com.ricci.almacen.controler;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.ricci.almacen.model.Categoria;
import com.ricci.almacen.model.Producto;
import com.ricci.almacen.service.CategoriaService;
import com.ricci.almacen.service.ProductoService;

import util.CustomErrorType;


/**
 * @author Ricardo
 *
 */
@Controller
@RequestMapping("/v1")
public class ProductoController {

	@Autowired
	ProductoService _productoService;
//	@Autowired
//	CategoriaService _categoriaService;

	/**
	 * GET
	 *
	 */
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	@RequestMapping(value="/productos", method = RequestMethod.GET, headers = "Accept=application/json")

	public ResponseEntity<List<Producto>> getProductos(){
		
		List<Producto> productos = new ArrayList<>();
		
		productos = _productoService.todosProductos();
		
		if(productos.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
		
		
	
	}
	  //GET BY ID
		@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
		@RequestMapping(value="/productos/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
		public ResponseEntity<Producto> econtrarPorId(@PathVariable("id") Long idProducto){
			if (idProducto == null || idProducto <= 0) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			
			Producto producto = _productoService.econtrarPorId(idProducto);
			if (producto == null) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<Producto>(producto, HttpStatus.OK);
		}
		
		
		//CREATE
	    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})	
	    @RequestMapping(value = "/producto", method = RequestMethod.POST, headers = "Accept=application/json")
	    public ResponseEntity<?> guardarProductos(@RequestBody Producto producto, UriComponentsBuilder ucBuilder) {
	        if (_productoService.encontrarPorNombre(producto.getNombreProducto()) != null) {
	            //logger.error("Unable to create. A User with name {} already exist", user.getName());
	            return new ResponseEntity(new CustomErrorType("Unable to create. A Producto with name " + 
	            		producto.getNombreProducto() + " already exist."),HttpStatus.CONFLICT);
	        }
	        _productoService.guardarProducto(producto);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/v1/producto/{id}").buildAndExpand(producto.getIdProducto()).toUri());
	        return new ResponseEntity<Producto>(producto, HttpStatus.CREATED);
	    }
		
		
		
		//UPDATE 
	    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
		@RequestMapping(value = "/productos/{id}", method = RequestMethod.PATCH)
			public ResponseEntity<?> actualizarProductos(@PathVariable("id") Long id, @RequestBody Producto producto) {
	        
			Producto currentProducto = _productoService.econtrarPorId(id);
	 
	        if (currentProducto == null) {
	            return new ResponseEntity(new CustomErrorType("Unable to upate. Producto with id " + id + " not found."),
	                    HttpStatus.NOT_FOUND);
	        }
	 
	        currentProducto.setNombreProducto(producto.getNombreProducto());
	        currentProducto.setPrecioProducto(producto.getPrecioProducto());
	        currentProducto.setFotoProducto(producto.getFotoProducto());
	        currentProducto.setFechaVencimiento(producto.getFechaVencimiento());

	        
	        _productoService.actualizarProducto(currentProducto);
	        return new ResponseEntity<Producto>(currentProducto, HttpStatus.OK);
	    }
		
		//DELETE
	    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	    @RequestMapping(value = "/producto/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	
		public ResponseEntity<?> eliminarProducto(@PathVariable("id") Long id) {
			System.out.println("Producto ID recived: " + id);
	 
			Producto producto = _productoService.econtrarPorId(id);
	        if (producto == null) {
	        	System.out.println("Unable to delete. Producto with id not found. " + id);
	            
	            return new ResponseEntity(new CustomErrorType("Unable to delete. Producto with id " + id + " not found."),
	                    HttpStatus.NOT_FOUND);
	        }
	        _productoService.eliminarProducto(id);
	        return new ResponseEntity<Producto>(HttpStatus.OK);
	    }
		
	
//	  //Asignar Categoria a Producto
//	  	@RequestMapping(value="/productos/categoria", method = RequestMethod.PATCH, headers="Accept=application/json")
//	  	public ResponseEntity<Producto> asignarCategoriaAproducto(@RequestBody Producto producto, UriComponentsBuilder ucBuilder){
//	  		if (producto.getIdProducto() == null || producto.getCategoria().getIdCategoria() == null) {
//	  			return new ResponseEntity(new CustomErrorType("We need almost id_categoira and id_producto "),HttpStatus.CONFLICT);
//	  		}
//	  		Producto productoSaved = _productoService.econtrarPorId(producto.getIdProducto());
//	  		if (productoSaved == null) {
//	  			return new ResponseEntity(new CustomErrorType("The id_producto: " + producto.getIdProducto() + " not found."),HttpStatus.CONFLICT);
//	  		}
//	  		Categoria categoria = _categoriaService.encontrarCategoriaPorId(producto.getCategoria().getIdCategoria());
//	  		if (categoria == null) {
//	  			return new ResponseEntity(new CustomErrorType("The id_categoria: " + producto.getCategoria().getIdCategoria() + " not found."),HttpStatus.CONFLICT);
//	  		}
//			productoSaved.setCategoria(categoria);;
//	  		_productoService.actualizarProducto(productoSaved);
//
//	  		return new ResponseEntity<Producto>(productoSaved, HttpStatus.OK);
//	  	}
//
	    
	    
}
