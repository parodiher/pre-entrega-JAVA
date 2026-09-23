package org.talentotech.productos;

public class Bebida extends Producto{
    private String volumenEnLitros;

    public Bebida() {
        super();
    }

    public Bebida(String nombre, Double precio, int stock, String volumenEnLitros) {
        super(nombre, precio, stock);
        this.volumenEnLitros = volumenEnLitros;
    }
}
