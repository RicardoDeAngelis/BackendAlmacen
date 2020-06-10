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
public interface CategoriaDao {


	void guardarCategoria(Categoria categoria);

	void eliminarCategoria(Long idCategoria);

	void actualizarCategoria(Categoria categoria);

	List<Categoria> listastodasCategorias();

	Categoria  encontrarCategoriaPorId(Long idCategoria);

	Categoria encontrarPorNombreCategoria(String nombreCategoria);
		
//	TeacherSocialMedia findSocialMediaByIdAndName(Long idSocialMedia, String nickname);
//	TeacherSocialMedia findSocialMediaByIdTeacherAndIdSocialMedia(Long idTeacher, Long idSocialMedia);

//	List<Categoria> buscarPorIdProducto(Long idProducto);

}
