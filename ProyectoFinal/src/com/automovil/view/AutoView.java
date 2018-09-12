package com.automovil.view;

import java.util.Scanner;

import com.automovil.control.AutoControl;

import com.compra.entity.Compra;

import excepciones.entity.CategoriaF;



public class AutoView {
	private AutoControl auto;
	private Compra compra;
	private Scanner scanner;
	public AutoView(AutoControl auto, Compra compra, Scanner scanner) {
		
		this.auto= auto;
		this.scanner = scanner;
		this.compra= compra;
	}
	public void addProduct() throws CategoriaF {
		AutoControl autos;
		
			autos = RegistroAuto.ingresar(scanner,compra);
	
		autos.ingresar(autos);
				
	}
	
	
	
	public void listProduct() {
    	int codigoAutomovil=0;
    	int indiceCategoria=0;
    	for(int i = 0; i <= auto.getCantidad(); i++) {
    		System.out.println(auto.getAutos() [i]);
    		codigoAutomovil = auto.getAutos()[i].getCodigoAutomovil();
    		try {
				indiceCategoria = compra.buscar(codigoAutomovil);
				System.out.println(compra.getCompra()[indiceCategoria]);
			} catch (CategoriaF e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    }
	public void deleteProduct() {
		int codProducto = InputTypes.readInt("Ingrese el codigo del producto", scanner);
		auto.eliminar(codigoAutomovil);	
	}

}
