package com.compra.entity;

public class Compra {
	private int fechaCompra;
	private int codigoDetCompra;
	private int codigoCompra;
	private String descuentos;
	private String garantia;
	

	public Compra (int fechaCompra, int codigoDetCompra, int codigoCompra, String descuentos, String garantia) {
		
	}


	public int getFechaCompra() {
		return fechaCompra;
	}


	public void setFechaCompra(int fechaCompra) {
		this.fechaCompra = fechaCompra;
	}


	public int getCodigoDetCompra() {
		return codigoDetCompra;
	}


	public void setCodigoDetCompra(int codigoDetCompra) {
		this.codigoDetCompra = codigoDetCompra;
	}


	public int getCodigoCompra() {
		return codigoCompra;
	}


	public void setCodigoCompra(int codigoCompra) {
		this.codigoCompra = codigoCompra;
	}


	public String getDescuentos() {
		return descuentos;
	}


	public void setDescuentos(String descuentos) {
		this.descuentos = descuentos;
	}


	public String getGarantia() {
		return garantia;
	}


	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}
	@Override
	public String toString() {
		return " Compra[codigo detalle de compra=" + codigoDetCompra + ", codigoCompra=" + codigoCompra + ", fechaVenta = (DD/MM/YY)" + fechaCompra + ", Garantia="
				+ garantia + "]";
	}
	

}
