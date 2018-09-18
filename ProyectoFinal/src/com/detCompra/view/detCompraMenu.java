package com.detCompra.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.detCompra.entity.DetalleDeCompra;

import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.compraFantasma;
import excepcionesInputTypes.detCompraFantasma;

public class detCompraMenu {
	private static int encabezado (Scanner scanner) {
		int opcion;
		
		while (true) {
			System.out.println("Ingrese una opcion; ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar detalle de compra");
			System.out.println("2. Listar detalle de compra");
			System.out.println("3. Eliminar detalle de compra");
			System.out.println("4. Actualizar detalle de compra");
			System.out.println("0. Salir");
			System.out.println();
			
			opcion = InputTypes.readInt("¿Su opcion?", scanner);
			
			if(opcion >= 0 && opcion <=4) {
				return opcion;
			}
		}
	}
	public static void menu (Scanner scanner, detCompraView detCompraView) {
		boolean salir = false;
		while(!salir) {
			switch(encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				try {
					detCompraView.addDetCompra();
				} catch (excepcionesInputTypes.autoFantasma e2) {
					System.out.println("no existe a compra");
					} catch (compraFantasma e2) {
				System.out.println("no existe a compra");
				}
				
				break;
			case 2:
				try {
					detCompraView.listDetCompra();
				} catch (SQLException e1) {
					System.out.println("no existe a compra");
					}
				break;
			case 3:
				
				try {
					detCompraView.deleteDetComrpa();
				} catch (SQLException e) {
					System.out.println("no existe a compra");
					}
				break;
			case 4:
				
					try {
						detCompraView.update();
					} catch (detCompraFantasma e) {
						System.out.println("no existe a compra");
						}
				 catch (excepcionesInputTypes.autoFantasma e) {
					System.out.println("no existe a compra");
					} catch (SQLException e) {
						System.out.println("no existe a compra");
						}
			}
		}
		
		
	}
	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		
		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar fecha compra");
			System.out.println("2. Modificar descuentos ");
			System.out.println("3. Modificar garantia ");
			System.out.println("4. Modificar codigo compra ");
			System.out.println("5. Modificar codigo automovil");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 5) {
				return opcion;
			}
		}
	}


	public static void menúModificar(Scanner scanner, DetalleDeCompra detCompra) {
		boolean salir = false;

		
		
		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				 detCompra.setFechaCompra(InputTypes.readInt("fechaCompra", scanner));
				 
				break;
			case 2:
				detCompra.setDescuentos(InputTypes.readInt("descuentos", scanner));
				 break;
			case 3:
				detCompra.setGarantia(InputTypes.readInt("garantia", scanner));
				break;
			case 4:
				detCompra.setCodigoCompra(InputTypes.readInt("Codigo compra", scanner));
				 break;
			case 5:
				detCompra.setCodigoAutomovil(InputTypes.readInt("Codigo Automovil", scanner));
				 
				break;
			}
		}
	}


}
