package com.proveedor.view;

import java.util.Scanner;

import com.proveedor.entity.Proveedor;

import excepcionesInputTypes.InputTypes;



public class proveedorRegistro {
	public static Proveedor ingresar(Scanner scanner) {
		
		String nombreProveedor= InputTypes.readString("Nombre: ", scanner);
		int codigoProveedor = InputTypes.readInt("Codigo empleado: ", scanner);
		
		return new Proveedor(codigoProveedor,nombreProveedor);
		
	}

}
