package com.ricci.almacen.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricci.almacen.dao.CategoriaDao;
import com.ricci.almacen.model.Categoria;

@Service("categoriaService")
@Transactional
public class CategoriaServiceImplementacion implements CategoriaService {

	@Autowired
	private CategoriaDao _categoriaDao;
	
	@Override
	public void guardarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		_categoriaDao.guardarCategoria(categoria);
	}

	@Override
	public void eliminarCategoria(Long idCategoria) {
		// TODO Auto-generated method stub
		_categoriaDao.eliminarCategoria(idCategoria);
	}

	@Override
	public void actualizarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		_categoriaDao.actualizarCategoria(categoria);
	}

	@Override
	public List<Categoria> listastodasCategorias() {
		// TODO Auto-generated method stub
		return _categoriaDao.listastodasCategorias();
	}

	@Override
	public Categoria encontrarCategoriaPorId(Long idCategoria) {
		// TODO Auto-generated method stub
		return _categoriaDao.encontrarCategoriaPorId(idCategoria);
	}

	@Override
	public Categoria encontrarPorNombreCategoria(String nombreCategoria) {
		// TODO Auto-generated method stub
		return _categoriaDao.encontrarPorNombreCategoria(nombreCategoria);
	}

	

//	@Override
//	public List<Producto> buscarPorIdProducto(Long idProducto) {
//		// TODO Auto-generated method stub
//		return _categoriaDao.buscarPorIdProducto(idProducto);
//	}

}
