package empleado.entity;

import com.automovil.entity.Auto;

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
	public Integer getCodigoEmpleado() {
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
	public boolean equals(Object o) {
		boolean respuesta = false;
		if ( o != null) {
			empleado empleado = (empleado) o;
			if(this.getCodigoEmpleado()==empleado.getCodigoEmpleado()) {
				respuesta = !respuesta;
			}
		}
		return respuesta;
	}
	
	public int hashCode() {
		return this.getCodigoEmpleado().hashCode();
	}

}
