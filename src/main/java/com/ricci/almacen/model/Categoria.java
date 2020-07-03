package com.ricci.almacen.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="categoria")
public class Categoria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_categoria")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategoria;
	
	@Column(name="nombre_categoria")
	private String nombreCategoria;
	
	@OneToMany(mappedBy="categoria")
	//@JoinColumn(name="id_categoria")

	
@JsonIgnore
	private Set<Producto> productos;
	
	
	
	
	

	/**
	 * @return the producto
	 */
	public Set<Producto> getProductos() {
		return productos;
	}



	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Set<Producto> productos) {
		this.productos = productos;
	}



	public Categoria( String nombreCategoria) {
		super();
		this.nombreCategoria = nombreCategoria;
		
	}

	

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @return the name_categoria
	 */
	public String getNombreCategoria() {
		return nombreCategoria;
	}



	/**
	 * @param name_categoria the name_categoria to set
	 */
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}



	/**
	 * @return the idCategoria
	 */
	public Long getIdCategoria() {
		return idCategoria;
	}


	
	
	
	

}
