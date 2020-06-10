/**
 * 
 */
package com.ricci.almacen.service;

import java.util.List;

import com.ricci.almacen.model.Producto;

/**
 * @author Ricardo
 *
 */
public interface ProductoService {

	void guardarProducto(Producto producto);

	void eliminarProducto(Long idProducto);

	void actualizarProducto(Producto producto);

	List<Producto> todosProductos();

	Producto  econtrarPorId(Long idProducto);

	Producto encontrarPorNombre(String name);

	//List<Producto> findByIdCategoria(Long idCategoria);

}
