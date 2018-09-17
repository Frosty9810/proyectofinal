package com.proveedor.entity;

public class Proveedor {
	private int codigoProveedor;
	private String nombreProveedor;
	
	public Proveedor(int codigoProveedor, String nombreProveedor) {
		
	}

	public int getCodigoProveedor() {
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
}
