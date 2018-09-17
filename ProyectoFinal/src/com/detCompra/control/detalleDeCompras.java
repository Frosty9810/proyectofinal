package com.detCompra.control;

import com.compra.entity.Compra;
import com.detCompra.entity.DetalleDeCompra;

import excepcionesInputTypes.compraFantasma;
import excepcionesInputTypes.detCompraFantasma;

public class detalleDeCompras {
	
	private detalleDeCompras[] detalleDeCompra;
	private int cantidad;
	private int ultimo;
	
	public detalleDeCompras (int tamaño) {
		detalleDeCompra = new detalleDeCompras[tamaño];
		cantidad = 0;
		ultimo = -1;
	}
	public void ingresar(detalleDeCompras detalleDeCompras) throws java.lang.ArrayIndexOutOfBoundsException {
		detalleDeCompra[++ultimo]=detalleDeCompras;
			cantidad++;
	}
	public void eliminar(int codigoDetCompra) throws compraFantasma {
		int indice = buscar(codigoDetCompra);
		if(indice>=0) {
			if(indice!=ultimo) {
				for(int i=indice; i<=ultimo;i++) {
					detalleDeCompra[i]=detalleDeCompra[i+1];
				}
			}
			ultimo--;
			cantidad--;
		}
		
	}
	public int buscar(int codigoDetCompra) throws detCompraFantasma {
		int posicion = -1;
		
		int indice=0;
		while(indice<=ultimo) {
			if(detalleDeCompra[indice].getDetCompra()==codigoDetCompra) {
				posicion=indice;
				break;
			}
			indice++;
		}
		if (posicion==-1){
		throw new detCompraFantasma();
		}
		return posicion;
	}
	
	
	public DetalleDeCompra[] getDetCompra() {
		return detalleDeCompra;
	}
	public int getCantidad() {
		return cantidad;
	}

}
