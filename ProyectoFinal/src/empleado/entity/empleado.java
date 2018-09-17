package empleado.entity;

public class empleado {
	private int codigoEmpleado;
	private String nombreEmpleado;
	private int DNIEmpleado;
	public empleado(int codigoEmpleado, String nombreEmpleado, int dNIEmpleado) {
		super();
		this.codigoEmpleado = codigoEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		DNIEmpleado = dNIEmpleado;
	}
	public int getCodigoEmpleado() {
		return codigoEmpleado;
	}
	public void setCodigoEmpleado(int codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
	public int getDNIEmpleado() {
		return DNIEmpleado;
	}
	public void setDNIEmpleado(int dNIEmpleado) {
		DNIEmpleado = dNIEmpleado;
	}
	@Override
	public String toString() {
		return "empleado [codigoEmpleado=" + codigoEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", DNIEmpleado="
				+ DNIEmpleado + "]";
	}

}
