package com.automovil.view;
import java.util.Scanner;

import com.automovil.entity.Auto;

import excepcionesInputTypes.InputTypes;

public class RegistroAuto {

			public static Auto ingresar(Scanner scanner) {


				String tipoAuto= InputTypes.readString("tipoAuto: ", scanner);
				int codigoAutomovil = InputTypes.readInt("Codigo auto: ", scanner);
				String marcaAuto =InputTypes.readString("marcaAuto: ", scanner);
				int numeroChasis = InputTypes.readInt("numeroChasis: ", scanner);
				String procedencia = InputTypes.readString("procedencia: ", scanner);
				String color = InputTypes.readString("Color:", scanner);
				double precio= InputTypes.readDouble("precio:", scanner);
				String garantia= InputTypes.readString("garantia:", scanner);;

				return new Auto(codigoAutomovil, tipoAuto, marcaAuto, numeroChasis, procedencia, color, precio,garantia);
				
			}

}
