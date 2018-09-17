package com.compra.view;

import java.util.Scanner;

import com.compra.control.compras;
import com.compra.entity.Compra;

import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.compraFantasma;



public class compraRegistro {
	public static Compra ingresar(Scanner scanner) throws compraFantasma {
		
		
		int codigoCompra = InputTypes.readInt("Codigo de Compra: ", scanner);
		int codigoProveedor = InputTypes.readInt("Codigo Proveedor: ", scanner);
		
		
		return new Compra(codigoCompra, codigoProveedor);
		
	}

}
