/**
 * 
 */
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
public class CategoriaController {
	
	
	@Autowired
	 CategoriaService _categoriaService;
	
//	@Autowired
//	private ProductoService _productoService;
	/**
	 * GET
	 *
	 */
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET})
	@RequestMapping(value="/categorias", method = RequestMethod.GET, headers = "Accept=application/json")

	public ResponseEntity<List<Categoria>> getCategorias(){
		
		List<Categoria> categorias = new ArrayList<>();
		
		categorias = _categoriaService.listastodasCategorias();
		
		if(categorias.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);

}
	
	
	
	  //GET BY ID
		@CrossOrigin(origins = "*", methods= {RequestMethod.GET})
		@RequestMapping(value="/categoria/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
		public ResponseEntity<Categoria> encontrarCategoriaPorId(@PathVariable("id") Long idCategoria){
			if (idCategoria == null || idCategoria <= 0) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			
			Categoria categoria = _categoriaService.encontrarCategoriaPorId(idCategoria);
			if (categoria == null) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
		}
		
		
		
		
		//DELETE
	    @CrossOrigin(origins = "*", methods= {RequestMethod.DELETE})
	    @RequestMapping(value = "/categoria/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	
		public ResponseEntity<?> eliminarCategoria(@PathVariable("id") Long id) {
			//System.out.println("categoria ID recived: " + id);
	 
			Categoria categoria = _categoriaService.encontrarCategoriaPorId(id);
	        if (categoria == null) {
	        	System.out.println("Unable to delete. categoria with id not found. " + id);
	            
	            return new ResponseEntity(new CustomErrorType("Unable to delete. Producto with id " + id + " not found."),
	                    HttpStatus.NOT_FOUND);
	        }
	        _categoriaService.eliminarCategoria(id);
	        return new ResponseEntity<Categoria>(HttpStatus.OK);
	    }
		

	
	
	
	//CREATE
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})	
    @RequestMapping(value = "/categoria", method = RequestMethod.POST, headers = "Accept=application/json")
    
    public ResponseEntity<?> guardarCategorias(@RequestBody Categoria categoria, UriComponentsBuilder ucBuilder) {
        if (_categoriaService.encontrarPorNombreCategoria(categoria.getNombreCategoria()) != null) {
            //logger.error("Unable to create. A User with name {} already exist", user.getName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Categoria with name " + 
            		categoria.getNombreCategoria()+ " already exist."),HttpStatus.CONFLICT);
        }
        _categoriaService.guardarCategoria(categoria);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/v1/categoria/{id}").buildAndExpand(categoria.getIdCategoria()).toUri());
        return new ResponseEntity<Categoria>(categoria, HttpStatus.CREATED);
    }
    
    //UPDATE 
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    
	@RequestMapping(value = "/categoria/{id}", method = RequestMethod.PATCH)
		
    
    public ResponseEntity<?> actualizarCategoria(@PathVariable("id") Long id, @RequestBody Categoria categoria){
        
		Categoria currentCategoria = _categoriaService.encontrarCategoriaPorId(id);
 
        if (currentCategoria == null) {
            return new ResponseEntity(new CustomErrorType("Unable to upate. Categoria with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
 
        currentCategoria.setNombreCategoria(categoria.getNombreCategoria());
       
        
        _categoriaService.actualizarCategoria(currentCategoria);
        return new ResponseEntity<Categoria>(currentCategoria, HttpStatus.OK);
    }
    
    

//    //Asignar Categoria a Producto
//  	@RequestMapping(value="/productos/categoria", method = RequestMethod.PATCH, headers="Accept=application/json")
//  	public ResponseEntity<Producto> asignarCategoriaAproducto(@RequestBody Producto producto, UriComponentsBuilder ucBuilder){
//  		if (producto.getIdProducto() == null || producto.getCategoria().getIdCategoria() == null) {
//  			return new ResponseEntity(new CustomErrorType("We need almost id_categoira and id_producto "),HttpStatus.CONFLICT);
//  		}
//  		Producto productoSaved = _productoService.econtrarPorId(producto.getIdProducto());
//  		if (productoSaved == null) {
//  			return new ResponseEntity(new CustomErrorType("The id_producto: " + producto.getIdProducto() + " not found."),HttpStatus.CONFLICT);
//  		}
//  		Categoria categoria = _categoriaService.encontrarCategoriaPorId(producto.getCategoria().getIdCategoria());
//  		if (categoria == null) {
//  			return new ResponseEntity(new CustomErrorType("The id_categoria: " + producto.getCategoria().getIdCategoria() + " not found."),HttpStatus.CONFLICT);
//  		}
//		productoSaved.setCategoria(categoria);;
//  		_productoService.actualizarProducto(productoSaved);
//
//  		return new ResponseEntity<Producto>(productoSaved, HttpStatus.OK);
//  	}


	
}
