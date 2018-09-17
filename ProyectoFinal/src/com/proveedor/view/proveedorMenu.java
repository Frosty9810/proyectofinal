package com.proveedor.view;

import java.util.Scanner;


import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.proveedorFantasma;

public class proveedorMenu {
	private static int encabezado (Scanner scanner) {
		int opcion;
		
		while (true) {
			System.out.println("Ingrese una opcion; ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar proveedor");
			System.out.println("2. Listar proveedor");
			System.out.println("3. Eliminar proveedor");
			System.out.println("0. Salir");
			System.out.println();
			
			opcion = InputTypes.readInt("¿Su opcion?", scanner);
			
			if(opcion >= 0 && opcion <=3) {
				return opcion;
			}
		}
	}
	public static void menu (Scanner scanner, proveedorView proveedorView) {
		boolean salir = false;
		while(!salir) {
			switch(encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				proveedorView.addProveedor();
				break;
			case 2:
				proveedorView.listProveedorC();
				break;
			case 3:
				try {
					proveedorView.deleteProveedorC();
				} catch (proveedorFantasma e) {
					System.out.println("No existe empleado");
				}
				break;
			}
		}
		
		
	}

}
