package DetVenta.entity;

public class detVenta {
	private int codigoDetVenta;
	private int fechaVentaAño;
	private int fechaVentaMes;
	private int fechaVentaDia;
	private int codigoEmpleado;
	private int codigoAutomovil;
	private int codigoVenta;
	
	
	
	public detVenta(int codigoDetVenta, int fechaVentaAño, int fechaVentaMes, int fechaVentaDia, int codigoEmpleado,
			int codigoAutomovil,int codigoVenta) {
		super();
		this.codigoDetVenta = codigoDetVenta;
		this.fechaVentaAño = fechaVentaAño;
		this.fechaVentaMes = fechaVentaMes;
		this.fechaVentaDia = fechaVentaDia;
		this.codigoEmpleado = codigoEmpleado;
		this.codigoAutomovil = codigoAutomovil;
		this.codigoVenta = codigoVenta;
	}
	
	public int getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public int getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(int codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public int getCodigoAutomovil() {
		return codigoAutomovil;
	}

	public void setCodigoAutomovil(int codigoAutomovil) {
		this.codigoAutomovil = codigoAutomovil;
	}

	public int getCodigoDetVenta() {
		return codigoDetVenta;
	}
	public void setCodigoDetVenta(int codigoDetVenta) {
		this.codigoDetVenta = codigoDetVenta;
	}
	public int getFechaVentaAño() {
		return fechaVentaAño;
	}
	public void setFechaVentaAño(int fechaVentaAño) {
		this.fechaVentaAño = fechaVentaAño;
	}
	public int getFechaVentaMes() {
		return fechaVentaMes;
	}
	public void setFechaVentaMes(int fechaVentaMes) {
		this.fechaVentaMes = fechaVentaMes;
	}
	public int getFechaVentaDia() {
		return fechaVentaDia;
	}
	public void setFechaVentaDia(int fechaVentaDia) {
		this.fechaVentaDia = fechaVentaDia;
	}
	@Override
	public String toString() {
		return "detVenta [codigoDetVenta=" + codigoDetVenta + ", fechaVentaAño=" + fechaVentaAño + ", fechaVentaMes="
				+ fechaVentaMes + ", fechaVentaDia=" + fechaVentaDia + ", codigoEmpleado=" + codigoEmpleado
				+ ", codigoAutomovil=" + codigoAutomovil + ", codigoVenta=" + codigoVenta + "]";
	}
	
	
	

}
