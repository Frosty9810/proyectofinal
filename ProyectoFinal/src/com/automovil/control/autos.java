package com.automovil.control;

public class autos {
	private int codigoAutomovil;
	private String tipoAuto;
	private String marcaAuto;
	private int numeroChasis;
	private String procedencia;
	private String color;
	private double precio;
	private String garantia;


	public autos (int codigoAutomovil, String tipoAuto, String marcaAuto, int numeroChasis, String procedencia, String color, double precio, String garantia) {
		super();
		this.codigoAutomovil=codigoAutomovil;
		this.tipoAuto=tipoAuto;
		this.marcaAuto=marcaAuto;
		this.numeroChasis=numeroChasis;
		this.procedencia=procedencia;
		this.color=color;
		this.precio=precio;
		this.garantia=garantia;
		
	
	}


	public int getCodigoAutomovil() {
		return codigoAutomovil;
	}


	public void setCodigoAutomovil(int codigoAutomovil) {
		this.codigoAutomovil = codigoAutomovil;
	}


	public String getTipoAuto() {
		return tipoAuto;
	}


	public void setTipoAuto(String tipoAuto) {
		this.tipoAuto = tipoAuto;
	}


	public String getMarcaAuto() {
		return marcaAuto;
	}


	public void setMarcaAuto(String marcaAuto) {
		this.marcaAuto = marcaAuto;
	}


	public int getNumeroChasis() {
		return numeroChasis;
	}


	public void setNumeroChasis(int numeroChasis) {
		this.numeroChasis = numeroChasis;
	}


	public String getProcedencia() {
		return procedencia;
	}


	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public String getGarantia() {
		return garantia;
	}


	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}
	@Override
	public String toString() {
		return "Automovil [codAutomovil=" + codigoAutomovil + ", Tipo de Automovil=" + tipoAuto + ", Marca de Automovil=" + marcaAuto + ", Numero de Chasis="
				+ numeroChasis + ", Procedencia del Automovil=" + procedencia + ", Color del Automovil=" + color + ", Precio=" + precio + "Garantia del Auto=" + garantia + "]";
	}
}