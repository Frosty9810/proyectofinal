package com.compra.control;

import com.compra.entity.Compra;

import excepcionesInputTypes.compraFantasma;
import excepcionesInputTypes.ventaFantasma;


public class compras {
	private Compra[] compras;
	private int cantidad;
	private int ultimo;
	
	public compras (int tamaño) {
		compras = new Compra[tamaño];
		cantidad = 0;
		ultimo = -1;
	}
	public void ingresar(Compra compra) throws java.lang.ArrayIndexOutOfBoundsException {
		compras[++ultimo]=compra;
			cantidad++;
	}
	public void eliminar(int codigoCompra) throws compraFantasma {
		int indice = buscar(codigoCompra);
		if(indice>=0) {
			if(indice!=ultimo) {
				for(int i=indice; i<=ultimo;i++) {
					compras[i]=compras[i+1];
				}
			}
			ultimo--;
			cantidad--;
		}
		
	}
	public int buscar(int codigoCompra) throws compraFantasma {
		int posicion = -1;
		
		int indice=0;
		while(indice<=ultimo) {
			if(compras[indice].getCodigoCompra()==codigoCompra) {
				posicion=indice;
				break;
			}
			indice++;
		}
		if (posicion==-1){
		throw new compraFantasma();
		}
		return posicion;
	}
	
	
	public Compra[] getCompra() {
		return compras;
	}
	public int getCantidad() {
		return cantidad;
	}
	
}
	


