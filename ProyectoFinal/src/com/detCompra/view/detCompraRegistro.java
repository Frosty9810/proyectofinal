package com.detCompra.view;

import excepcionesInputTypes.InputTypes;
import excepcionesInputTypes.autoFantasma;
import excepcionesInputTypes.compraFantasma;

import com.compra.control.compras;
import com.detCompra.entity.DetalleDeCompra;

import java.util.Scanner;

import com.automovil.control.Autos;



public class detCompraRegistro{
	public static DetalleDeCompra ingresar(compras compras, Autos autos, Scanner scanner) throws autoFantasma, compraFantasma {
	
	int codigoDetCompra=InputTypes.readInt("Codigo detalle de compra", scanner);
	 int fechaCompra = InputTypes.readInt("fechaCompra", scanner);
	 int descuentos= InputTypes.readInt("descuentos", scanner);
	 int garantia= InputTypes.readInt("garantia", scanner);
	
	 int codigoCompra= InputTypes.readInt("Codigo compra", scanner);
	 compras.buscar(codigoCompra);
	 int codigoAtomovil= InputTypes.readInt("Codigo Automovil", scanner);
	 autos.buscar(codigoAtomovil);
	
	
	return new DetalleDeCompra(codigoDetCompra,fechaCompra,descuentos,garantia,codigoCompra,codigoAtomovil);
	
}}

