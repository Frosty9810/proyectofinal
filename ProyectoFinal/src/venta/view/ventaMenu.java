package venta.view;

import java.util.Scanner;

import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.clienteFantasma;
import excepcionesInputTypes.ventaFantasma;

public class ventaMenu {
			private static int encabezado (Scanner scanner) {
				int opcion;
				
				while (true) {
					System.out.println("Ingrese una opcion; ");
					System.out.println("------------------- ");
					System.out.println("1. Ingresar venta");
					System.out.println("2. Listar venta");
					System.out.println("3. Eliminar venta");
					System.out.println("0. Salir");
					System.out.println();
					
					opcion = InputTypes.readInt("¿Su opcion?", scanner);
					
					if(opcion >= 0 && opcion <=3) {
						return opcion;
					}
				}
			}
			public static void menu (Scanner scanner, ventaView ventaView) {
				boolean salir = false;
				while(!salir) {
					switch(encabezado(scanner)) {
					case 0:
						salir = true;
						break;
					case 1:
						try {
							ventaView.addVenta();
						} catch (clienteFantasma e1) {
							System.out.println("No existe el cliente");
						}
						break;
					case 2:
						ventaView.listVenta();
						break;
					case 3:
						try {
							ventaView.deleteVenta();
						} catch (ventaFantasma e) {
							System.out.println("No existe venta");
						}
						break;
					}
				}
				
				
			}

}
