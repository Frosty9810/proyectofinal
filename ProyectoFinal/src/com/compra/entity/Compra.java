package com.compra.entity;


public class Compra {
	private int codigoCompra;
	private int codigoProveedor;
	

	public Compra (int codigoCompra, int codigoProveedor) {
		
	}
	

	
	public Integer getCodigoCompra() {
		return codigoCompra;
	}



	public void setCodigoCompra(int codigoCompra) {
		this.codigoCompra = codigoCompra;
	}



	public int getCodigoProveedor() {
		return codigoProveedor;
	}



	public void setCodigoProveedor(int codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}



	@Override
	public String toString() {
		return " Compra[codigo detalle de compra=" + codigoCompra + ", codigoCompra=" + codigoProveedor + "]";
	}
	public boolean equals(Object o) {
		boolean respuesta = false;
		if ( o != null) {
			Compra compra = (Compra) o;
			if(this.getCodigoCompra()==compra.getCodigoCompra()) {
				respuesta = !respuesta;
			}
		}
		return respuesta;
	}
	
	public int hashCode() {
		return this.getCodigoCompra().hashCode();
	}

}
