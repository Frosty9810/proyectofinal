package venta.view;

import java.sql.SQLException;
import java.util.Scanner;


import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.clienteFantasma;
import venta.entity.venta;

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
						System.out.println("NO existe la venta");
						}
						break;
					case 2:
						try {
							ventaView.listVenta();
						} catch (SQLException e) {
							System.out.println("No existe venta");
							}
						break;
					case 3:
						try {
							ventaView.deleteVenta();
						} catch (SQLException e) {
							System.out.println("No existe venta");
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
					System.out.println("1. Modificar codigoCliente");
					System.out.println("2. Modificar numeroVenta");
					System.out.println("3. Modificar reservacion");
					System.out.println("0. Salir");
					System.out.println();

					opcion = InputTypes.readInt("¿Su opción? ", scanner);

					if (opcion >= 0 && opcion <= 3) {
						return opcion;
					}
				}
			}


			public static void menúModificar(Scanner scanner, venta venta) {
					boolean salir = false;

				
				while (!salir) {
					switch (encabezadoModificar(scanner)) {
					case 0:
						salir = true;
						break;
					case 1:
						 venta.setCodigoCliente(InputTypes.readInt("nombre Proveedor:", scanner));
								
						 break;
					case 2:
						 venta.setNumeroVenta(InputTypes.readInt("nombre Proveedor:", scanner));
					
						break;
					case 3:
						 venta.setReservacion(InputTypes.readString("nombre Proveedor:", scanner));
							
						break;
					}
				}
			}
			


}
