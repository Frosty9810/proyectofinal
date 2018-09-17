package com.proveedor.control;

import com.proveedor.entity.Proveedor;

import excepcionesInputTypes.proveedorFantasma;

public class ProveedorC {
	private Proveedor[] proveedores;
	private int cantidad;
	private int ultimo;
	
	public ProveedorC (int tamaño) {
		proveedores = new Proveedor[tamaño];
		cantidad = 0;
		ultimo = -1;
	}
	public void ingresar(Proveedor proveedor) throws java.lang.ArrayIndexOutOfBoundsException {
		proveedores[++ultimo]=proveedor;
			cantidad++;
	}
	public void eliminar(int codigoProveedor) throws proveedorFantasma {
		int indice = buscar(codigoProveedor);
		if(indice>=0) {
			if(indice!=ultimo) {
				for(int i=indice; i<=ultimo;i++) {
					proveedores[i]=proveedores[i+1];
				}
			}
			ultimo--;
			cantidad--;
		}
		
	}
	public int buscar(int codigoProveedor) throws proveedorFantasma {
		int posicion = -1;
		
		int indice=0;
		while(indice<=ultimo) {
			if(proveedores[indice].getCodigoProveedor()==codigoProveedor) {
				posicion=indice;
				break;
			}
			indice++;
		}
		if (posicion==-1){
		throw new proveedorFantasma();
		}
		return posicion;
	}
	
	
	public Proveedor[] getProveedor() {
		return proveedores;
	}
	public int getCantidad() {
		return cantidad;
	}

}
