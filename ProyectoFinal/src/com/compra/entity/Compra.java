package com.compra.entity;

public class Compra {
	private int codigoCompra;
	private int codigoProveedor;
	

	public Compra (int codigoCompra, int codigoProveedor) {
		
	}
	

	
	public int getCodigoCompra() {
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
	

}
