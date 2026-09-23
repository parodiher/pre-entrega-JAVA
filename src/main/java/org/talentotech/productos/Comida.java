package org.talentotech.productos;

public class Comida extends Producto{
    private String fechaVencimiento;

    public Comida(){
        super();
    }

    public Comida(String nombre, Double precio, int stock, String fechaVencimiento) {
        super(nombre, precio, stock);
        this.fechaVencimiento = fechaVencimiento;
    }
}
