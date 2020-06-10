/**
 * 
 */
package com.ricci.almacen.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricci.almacen.dao.ProductoDao;
import com.ricci.almacen.model.Producto;

/**
 * @author Ricardo
 *
 */
@Service("ProductoService")
@Transactional
public class productoServiceImplementacion implements ProductoService {

	@Autowired
	private ProductoDao _productoDao;
	
	@Override
	public void guardarProducto(Producto producto) {
		// TODO Auto-generated method stub
		_productoDao.guardarProducto(producto);
		
	}

	@Override
	public void eliminarProducto(Long idProducto) {
		// TODO Auto-generated method stub
		_productoDao.eliminarProducto(idProducto);
		
	}

	@Override
	public void actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		_productoDao.actualizarProducto(producto);
	}

	@Override
	public List<Producto> todosProductos() {
		// TODO Auto-generated method stub
		return _productoDao.todosProductos();
	}

	@Override
	public Producto econtrarPorId(Long idProducto) {
		// TODO Auto-generated method stub
		return _productoDao.econtrarPorId(idProducto);
	}

	@Override
	public Producto encontrarPorNombre(String name) {
		// TODO Auto-generated method stub
		return _productoDao.encontrarPorNombre(name);
	}

	

//	@Override
//	public List<Producto> findByIdCategoria(Long idCategoria) {
//		// TODO Auto-generated method stub
//		return _productoDao.findByIdCategoria(idCategoria);
//	}

}
