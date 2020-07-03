/**
 * 
 */
package com.ricci.almacen.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ricci.almacen.model.Categoria;
import com.ricci.almacen.model.Producto;

/**
 * @author Ricardo
 *
 */
@Repository
@Transactional
public class CategoriaDaoImplementacion extends AbstractSession implements CategoriaDao{

	@Override
	public void guardarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		getSession().persist(categoria);
	}

	@Override
	public void eliminarCategoria(Long idCategoria) {
		// TODO Auto-generated method stub
		Categoria categoria = encontrarCategoriaPorId(idCategoria);
		if(categoria != null) {
			getSession().delete(categoria);	
		}
		
	}

	@Override
	public void actualizarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		getSession().update(categoria);
	}

	@Override
	public List<Categoria> listastodasCategorias() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Categoria").list();
	}

	@Override
	public Categoria encontrarCategoriaPorId(Long idCategoria) {
		// TODO Auto-generated method stub
		return (Categoria) getSession().get(Categoria.class, idCategoria ) ;
	}

	@Override
	public Categoria encontrarPorNombreCategoria(String nombreCategoria) {
		// TODO Auto-generated method stub
		return (Categoria) getSession().createQuery(
				"from Categoria where nombreCategoria = :nombreCategoria")
				.setParameter("nombreCategoria",nombreCategoria).uniqueResult();
	}



//	@Override
//	public List<Producto> buscarPorIdProducto(Long idProducto) {
//		// TODO Auto-generated method stub
//		return (List<Producto>) getSession().createQuery(
//				"from  c join c.producto t where t.idProducto = :idProducto")
//				.setParameter("idProducto", idProducto).list();
//	}

}
