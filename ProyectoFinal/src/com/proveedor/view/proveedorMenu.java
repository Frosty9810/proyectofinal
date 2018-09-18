package com.proveedor.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.proveedor.entity.Proveedor;

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
			System.out.println("4. modificar proveedor");
			
			System.out.println("0. Salir");
			System.out.println();
			
			opcion = InputTypes.readInt("¿Su opcion?", scanner);
			
			if(opcion >= 0 && opcion <=4) {
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
				try {
					proveedorView.listProveedor();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 3:
				try {
					proveedorView.deleteProveedor();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				break;
			case 4:
				try {
					proveedorView.update();
				} catch (SQLException e) {
					System.out.println("no existe el proveedor");
					}
				 catch (proveedorFantasma e) {
					System.out.println("no existe el proveedor");
					}
				}
					break;
			}
			}
			
		
		
		

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		
		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar nombre");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 1) {
				return opcion;
			}
		}
	}


	public static void menúModificar(Scanner scanner, Proveedor proveedor) {
			boolean salir = false;

		
		
		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				 proveedor.setNombreProveedor(InputTypes.readString("nombre Proveedor:", scanner));
				break;
			}
		}
	}
	
}



