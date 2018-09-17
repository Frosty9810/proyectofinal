package com.compra.view;

import java.util.Scanner;
import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.compraFantasma;
import excepcionesInputTypes.proveedorFantasma;


public class compraMenu {
	private static int encabezado (Scanner scanner) {
		int opcion;
		
		while (true) {
			System.out.println("Ingrese una opcion; ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar compra");
			System.out.println("2. Listar venta");
			System.out.println("3. Eliminar compra");
			System.out.println("0. Salir");
			System.out.println();
			
			opcion = InputTypes.readInt("¿Su opcion?", scanner);
			
			if(opcion >= 0 && opcion <=3) {
				return opcion;
			}
		}
	}
	public static void menu (Scanner scanner, compraView compraView) {
		boolean salir = false;
		while(!salir) {
			switch(encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					compraView.addCompra();
				} catch (compraFantasma e1) {
					System.out.println("No existe el proveedor");
				}
				break;
			case 2:
				compraView.listCompra();
				break;
			case 3:
				try {
					compraView.deleteCompra();
				} catch (compraFantasma e) {
					System.out.println("No existe compra");
				}
				break;
			}
		}
		
		
	}

}
