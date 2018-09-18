package com.proveedor.entity;

import com.automovil.entity.Auto;

public class Proveedor {
	private int codigoProveedor;
	private String nombreProveedor;
	
	public Proveedor(int codigoProveedor, String nombreProveedor) {
		
	}

	public Integer getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(int codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	@Override
	public String toString() {
		return " Proveedor[codigo del proveedor=" + codigoProveedor + ", Nombre del Proveedor=" + nombreProveedor + "]";

	}
	public boolean equals(Object o) {
		boolean respuesta = false;
		if ( o != null) {
			Proveedor proveedor = (Proveedor) o;
			if(this.getCodigoProveedor()==proveedor.getCodigoProveedor()) {
				respuesta = !respuesta;
			}
		}
		return respuesta;
	}
	
	public int hashCode() {
		return this.getCodigoProveedor().hashCode();
	}
}
