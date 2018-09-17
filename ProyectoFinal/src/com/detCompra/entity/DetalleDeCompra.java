package com.detCompra.entity;

public class DetalleDeCompra {
	private int codigoDetCompra;
	private int fechaCompra;
	private int descuentos;
	private int garantia;
	private int codigoCompra;
	private int codigoAutomovil;
	
	public DetalleDeCompra(int codigoDetCompra, int fechaCompra, int descuetnos, int garantia, int codigoCompra, int codigoAutomovil) {
		
	}

	public int getCodigoDetCompra() {
		return codigoDetCompra;
	}

	public void setCodigoDetCompra(int codigoDetCompra) {
		this.codigoDetCompra = codigoDetCompra;
	}

	public int getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(int fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public int getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(int descuentos) {
		this.descuentos = descuentos;
	}

	public int getGarantia() {
		return garantia;
	}

	public void setGarantia(int garantia) {
		this.garantia = garantia;
	}

	public int getCodigoCompra() {
		return codigoCompra;
	}

	public void setCodigoCompra(int codigoCompra) {
		this.codigoCompra = codigoCompra;
	}

	public int getCodigoAutomovil() {
		return codigoAutomovil;
	}

	public void setCodigoAutomovil(int codigoAutomovil) {
		this.codigoAutomovil = codigoAutomovil;
	}
	@Override
	public String toString() {
		return "Detalle de Compra [codigo del detalle de compra=" + codigoDetCompra + ", fecha de la compra=" + fechaCompra + ", descuentos=" + descuentos
				+ ", garantia=" + garantia + ", codigo compra=" + codigoCompra + ", codigo del auto: " + codigoAutomovil +  "]";
}
