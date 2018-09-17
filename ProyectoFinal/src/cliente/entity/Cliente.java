package cliente.entity;

public class Cliente {
	private int codCliente;
	private int DNIcliente;
	private String nombreCliente;
	private String direccion;
	private int telefono;
	
	
	public Cliente(int codCliente, int dNIcliente, String nombreCliente, String direccion, int telefono) {
		super();
		this.codCliente = codCliente;
		DNIcliente = dNIcliente;
		this.nombreCliente = nombreCliente;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public int getDNIcliente() {
		return DNIcliente;
	}
	public void setDNIcliente(int dNIcliente) {
		DNIcliente = dNIcliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Cliente [codCliente=" + codCliente + ", DNIcliente=" + DNIcliente + ", nombreCliente=" + nombreCliente
				+ ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}

}
