package com.detCompra.control;

import com.detCompra.entity.DetalleDeCompra;

import excepcionesInputTypes.detCompraFantasma;

public class detalleDeCompras {
	
	private DetalleDeCompra[] detalleDeCompra;
	private int cantidad;
	private int ultimo;
	
	public detalleDeCompras (int tamaño) {
		detalleDeCompra = new DetalleDeCompra[tamaño];
		cantidad = 0;
		ultimo = -1;
	}
	public void ingresar(DetalleDeCompra detalleDeCompras) throws java.lang.ArrayIndexOutOfBoundsException {
		detalleDeCompra[++ultimo]=detalleDeCompras;
			cantidad++;
	}
	public void eliminar(int codigoDetCompra) throws detCompraFantasma {
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
			if(detalleDeCompra[indice].getCodigoDetCompra() ==codigoDetCompra) {
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
