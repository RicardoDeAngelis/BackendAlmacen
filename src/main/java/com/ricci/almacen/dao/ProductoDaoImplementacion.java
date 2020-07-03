/**
 * 
 */
package com.ricci.almacen.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ricci.almacen.model.Producto;

/**
 * @author Ricardo
 *
 */
@Repository
@Transactional
public class ProductoDaoImplementacion extends AbstractSession implements ProductoDao {

	/**
	 * 
	 */
	

	@Override
	public void guardarProducto(Producto producto) {
		// TODO Auto-generated method stub
		getSession().persist(producto);
		
	}

	@Override
	public void eliminarProducto(Long idProducto) {
		// TODO Auto-generated method stub
		Producto producto = econtrarPorId(idProducto);
		if(producto != null) {
			getSession().delete(producto);
		}
		
		
	}

	@Override
	public void actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		getSession().update(producto);
		
	}

	@Override
	public List<Producto> todosProductos() {
		// TODO Auto-generated method stub
		
		return  getSession().createQuery("from Producto").list();
		
		
	}

	@Override
	public Producto econtrarPorId(Long idProducto) {
		// TODO Auto-generated method stub
		return (Producto) getSession().get(Producto.class, idProducto);
	}

	@Override
	public Producto encontrarPorNombre(String nombreProducto) {
		// TODO Auto-generated method stub
		return (Producto) getSession().createQuery(
				"from Producto where nombreProducto = :nombreProducto")
				.setParameter("nombreProducto", nombreProducto).uniqueResult();
	}

	@Override
	public List<Producto> findByIdCategoria(Long idCategoria ) {
		// TODO Auto-generated method stub
		return (List<Producto>) getSession().createQuery(
				"from Producto c join c.categoria t where t.idCategoria = :idCategoria")
				.setParameter("idCategoria", idCategoria).list();
	}
//
//	@Override
//	public Producto findProductoByIdCategoriaAndIdCategoria(Long idPorducto, Long idCategoria) {
//		// TODO Auto-generated method stub
//		
//		List<Object[]> objects = getSession().createQuery(
//				"from Producto tsm join tsm.categoria sm "
//				+ "where sm.idCategoria = :idCategoria ")
//				.setParameter("idCategoria", idCategoria).list();
//		
//		if (objects.size() > 0) {
//			for (Object[] objects2 : objects) {
//				for (Object object : objects2) {
//					if (object instanceof Producto) {
//						return (Producto) object;
//					}
//				}
//			}
//		}
//		
//		return null;
//	}

}
