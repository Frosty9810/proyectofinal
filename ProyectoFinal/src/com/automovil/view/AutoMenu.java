package com.automovil.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.automovil.entity.Auto;

import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.autoFantasma;



public class AutoMenu {
	private static int encabezado (Scanner scanner) {
		int opcion;
		
		while (true) {
			System.out.println("Ingrese una opcion; ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Detalles del Auto");
			System.out.println("2. Listar Autos");
			System.out.println("3. Eliminar Auto");
			System.out.println("4. modificar Autos");
			System.out.println("0. Salir");
			System.out.println();
			
			opcion = InputTypes.readInt("¿Su opcion?", scanner);
			
			if(opcion >= 0 && opcion <=4) {
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
				autoView.addAuto();
				break;
			case 2:
				try {
					autoView.listAuto();
				} catch (SQLException e1) {
					System.out.println("No existe el auto");
					}
				break;
			case 3:
				try {
					autoView.deleteAuto();
				} catch (SQLException e) {
					System.out.println("No existe el auto");
				}
				break;
			case 4:
				try {
					autoView.update();
				} catch (autoFantasma e) {
					System.out.println("No existe el auto");
					} catch (SQLException e) {
						System.out.println("No existe el auto");
						}
			
			}
		}
		
		
	}
	
	private static int encabezadoModificar(Scanner scanner) {
		int opcion;


		
		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar tipo");
			System.out.println("2. Modificar marca ");
			System.out.println("3. Modificar numero chasis");
			System.out.println("4. Modificar procedemcia ");
			System.out.println("5. Modificar color");
			System.out.println("6. Modificar percio ");
			System.out.println("7. Modificar garantia");
			
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 7) {
				return opcion;
			}
		}
	}


	public static void menúModificar(Scanner scanner, Auto auto) {
		boolean salir = false;

		
		
		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				
				auto.setTipoAuto(InputTypes.readString("tipoAuto: ", scanner));

				
				break;
			case 2:
				auto.setMarcaAuto(InputTypes.readString("marcaAuto: ", scanner));

				break;
			case 3:
				auto.setNumeroChasis(InputTypes.readInt("numeroChasis: ", scanner));

				break;
			case 4:
				
				auto.setProcedencia(InputTypes.readString("procedencia: ", scanner));
				break;
			case 5: auto.setColor(InputTypes.readString("Color:", scanner));
			break;
			case 6: auto.setPrecio(InputTypes.readDouble("precio:", scanner));
			break;
			case 7: auto.setGarantia(InputTypes.readString("garantia:", scanner));
			break;
				
			}
		}
	}


}
