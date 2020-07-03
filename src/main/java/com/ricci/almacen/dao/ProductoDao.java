/**
 * 
 */
package com.ricci.almacen.dao;

import java.util.List;

import com.ricci.almacen.model.Categoria;
import com.ricci.almacen.model.Producto;

/**
 * @author Ricardo
 *
 */
public interface ProductoDao {
	
	
	void guardarProducto(Producto producto);

	void eliminarProducto(Long idProducto);

	void actualizarProducto(Producto producto);

	List<Producto> todosProductos();

	Producto  econtrarPorId(Long idProducto);

	Producto encontrarPorNombre(String name);

//	TeacherSocialMedia findSocialMediaByIdAndName(Long idSocialMedia, String nickname);
//	
//	Producto findProductoByIdCategoriaAndIdCategoria(Long idPorducto, Long idCategoria);
//
     List<Producto> findByIdCategoria(Long idCategoria);

}
