/**
 * 
 */
package com.ricci.almacen.service;

import java.util.List;

import com.ricci.almacen.model.Categoria;
import com.ricci.almacen.model.Producto;

/**
 * @author Ricardo
 *
 */
public interface CategoriaService {

	void guardarCategoria(Categoria categoria);

	void eliminarCategoria(Long idCategoria);

	void actualizarCategoria(Categoria categoria);

	List<Categoria> listastodasCategorias();

	Categoria  encontrarCategoriaPorId(Long idCategoria);

	Categoria encontrarPorNombreCategoria(String nombreCategoria);
	
//	List<Producto> buscarPorIdProducto(Long idProducto);
	

}
