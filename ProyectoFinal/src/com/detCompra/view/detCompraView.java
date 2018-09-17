package com.detCompra.view;

import java.util.Scanner;

import com.automovil.control.autos;


public class detCompraView {
	private detVentas detVentas;
	private Scanner scanner;
	private empleados empleados;
	private ventas ventas;
	private autos autos;
	
	public detVentaView(detVentas detVentas,empleados empleados,ventas ventas,autos autos,Scanner scanner) {
		
		this.detVentas = detVentas;
		
		this.scanner = scanner;
	}
	
	public void addDetVenta()throws empleadoFantasma, autoFantasma, ventaFantasma {
		detVenta detVenta;
		
		detVenta = detVentaRegistro.ingresar(scanner, empleados, ventas, autos);
		detVentas.ingresar(detVenta);
				
	}
	
	public void listDetVenta() {
		for(int i=0; i<detVentas.getCantidad(); i++) {
			System.out.println(detVentas.getDetVenta()[i]);
		}
	}
	
	public void deleteDetVenta() throws detVentaFantasma {
		int codDetVenta = InputTypes.readInt("Ingrese el codigo del detalle de venta", scanner);
		detVentas.eliminar(codDetVenta);	
	}

	public detVentas getDetVenta() {
		return detVentas;
	}

}
