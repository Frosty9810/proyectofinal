package venta.entity;

public class venta {
	private int codigoVenta;
	private int codigoCliente;
	private int numeroVenta;
	private String reservacion;
	public venta(int codigoVenta, int numeroVenta, String reservacion, int codigoCliente) {
		super();
		this.codigoVenta = codigoVenta;
		this.numeroVenta = numeroVenta;
		this.reservacion = reservacion;
		this.codigoCliente = codigoCliente;
	}
	public int getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public int getCodigoVenta() {
		return codigoVenta;
	}
	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}
	public int getNumeroVenta() {
		return numeroVenta;
	}
	public void setNumeroVenta(int numeroVenta) {
		this.numeroVenta = numeroVenta;
	}
	public String getReservacion() {
		return reservacion;
	}
	public void setReservacion(String reservacion) {
		this.reservacion = reservacion;
	}
	@Override
	public String toString() {
		return "venta [codigoVenta=" + codigoVenta + ", codigoCliente=" + codigoCliente + ", numeroVenta=" + numeroVenta
				+ ", reservacion=" + reservacion + "]";
	}
	

}
