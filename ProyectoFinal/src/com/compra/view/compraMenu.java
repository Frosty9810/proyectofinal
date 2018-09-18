package com.compra.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.compra.entity.Compra;

import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.compraFantasma;


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
	public static void menu (Scanner scanner, CompraView compraView) {
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
				try {
					compraView.listCompra();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 3:
				try {
					compraView.deleteCompra();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
		
		
	}
	
	private static int encabezadoModificar(Scanner scanner) {
		int opcion;


		
		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar codigo proveedor");
			
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 1) {
				return opcion;
			}
		}
	}


	public static void menúModificar(Scanner scanner, Compra compra) {
		boolean salir = false;

		
		
		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				
				compra.setCodigoProveedor(InputTypes.readInt("codigo Proveedor: ", scanner));

				
				break;			}
		}
	}



}
