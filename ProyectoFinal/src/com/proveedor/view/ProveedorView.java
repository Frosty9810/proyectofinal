package com.proveedor.view;

import java.util.Scanner;


import com.proveedor.control.ProveedorC;
import com.proveedor.entity.Proveedor;



import excepcionesInputTypes.InputTypes;

import excepcionesInputTypes.proveedorFantasma;

public class proveedorView {
	private ProveedorC proveedores;
	private Scanner scanner;
	
	public proveedorView(Scanner scanner, ProveedorC proveedores) {
		
		this.proveedores = proveedores;
		
		this.scanner = scanner;
	}
	
	public void addProveedor() {
		Proveedor proveedor;
		
		proveedor = proveedorRegistro.ingresar(scanner);
		proveedores.ingresar(proveedor);
				
	}
	
	public void listProveedorC() {
		for(int i=0; i<proveedores.getCantidad(); i++) {
			System.out.println(proveedores.getProveedor()[i]);
		}
	}
	
	public void deleteProveedorC() throws proveedorFantasma {
		int codigoProveedor = InputTypes.readInt("Ingrese el codigo del proveedor", scanner);
		proveedores.eliminar(codigoProveedor);	
	}

	public ProveedorC getProveedorC() {
		return proveedores;
	}
}

