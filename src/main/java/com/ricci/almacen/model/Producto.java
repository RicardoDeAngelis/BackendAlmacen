package com.ricci.almacen.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="producto")
public class Producto implements Serializable{
	
	@Id
	@Column(name="id_producto")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProducto;
	
	@Column(name="precio")
	private Double precioProducto;
	
	@Column(name="foto")
	private String fotoProducto;

	
	@Column(name="nombre_producto")
	private String nombreProducto;
	
	
	@Column(name="fecha")
	private Date fechaVencimiento;

	@ManyToOne(optional=true,fetch=FetchType.EAGER)
	@JoinColumn(name="id_categoria")
//	@JsonIgnore
	private Categoria categoria;
	


	/**
 * @param precioProducto
 * @param fotoProducto
 * @param nombreProducto
 * @param fechaVencimiento
 */
public Producto(Double precioProducto, String fotoProducto, String nombreProducto, Date fechaVencimiento) {
	super();
	this.precioProducto = precioProducto;
	this.fotoProducto = fotoProducto;
	this.nombreProducto = nombreProducto;
	this.fechaVencimiento = fechaVencimiento;
}





	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}
//
//
//
//
//
//	/**
//	 * @param categoria the categoria to set
//	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}





	/**
	 * @return the fotoProducto
	 */
	public String getFotoProducto() {
		return fotoProducto;
	}

	/**
	 * @param fotoProducto the fotoProducto to set
	 */
	public void setFotoProducto(String fotoProducto) {
		this.fotoProducto = fotoProducto;
	}





	/**
	 * @return the fechaVencimiento
	 */
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}





	/**
	 * @param fechaVencimiento the fechaVencimiento to set
	 */
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}





	/**
	 * @return the idProducto
	 */
	public Long getIdProducto() {
		return idProducto;
	}





	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the precioProducto
	 */
	public Double getPrecioProducto() {
		return precioProducto;
	}


	/**
	 * @param precioProducto the precioProducto to set
	 */
	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}


	/**
	 * @return the nombreProducto
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}


	/**
	 * @param nombreProducto the nombreProducto to set
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	
	
}

	
