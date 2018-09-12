package com.automovil.view;

import java.util.Scanner;

import excepciones.entity.CategoriaF;



public class AutoMenu {
	private static int encabezado (Scanner scanner) {
		int opcion;
		
		while (true) {
			System.out.println("Ingrese una opcion; ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Detalles del Auto");
			System.out.println("2. Listar Autos");
			System.out.println("3. Eliminar Auto");
			
			System.out.println("0. Salir");
			System.out.println();
			
			opcion = InputTypes.readInt("¿Su opcion?", scanner);
			
			if(opcion >= 0 && opcion <=3) {
				return opcion;
			}
		}
	}
	public static void menu (Scanner scanner, AutoView autoView) {
		boolean salir = false;
		while(!salir) {
			switch(encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					autoView.addProduct();
				} catch (CategoriaF e) {
					System.out.println("No existe la categoria");
				}
				break;
			case 2:
				autoView.listProduct();
				break;
			case 3:
				autoView.deleteProduct();
				break;
			
			}
		}
		
		
	}
}
