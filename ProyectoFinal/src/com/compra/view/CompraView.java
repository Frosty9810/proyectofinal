package com.compra.view;

import java.util.Scanner;

import com.compra.entity.Compra;
import com.proveedor.entity.Proveedor;

import cliente.control.clientes;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.clienteFantasma;
import excepcionesInputTypes.compraFantasma;
import excepcionesInputTypes.proveedorFantasma;
import excepcionesInputTypes.ventaFantasma;
import com.compra.control.compras;


public class compraView {
	private compras compras;
	private Scanner scanner;

	public compraView(compras compras ,Scanner scanner) {
		
		this.compras = compras;
		
		this.scanner = scanner;
	}
	
	public void addCompra() throws compraFantasma {
		Compra compra;
		
		compra = compraRegistro.ingresar(scanner);
		compras.ingresar(compra);
				
	}
	
	public void listCompra() {
		for(int i=0; i<compras.getCantidad(); i++) {
			System.out.println(compras.getCompra()[i]);
		}
	}
	
	public void deleteCompra() throws compraFantasma {
		int codigoCompra = InputTypes.readInt("Ingrese el codigo de la compra: ", scanner);
		compras.eliminar(codigoCompra);	
	}

	public compras getCompra() {
		return compras;
	}
}


