package org.talentotech.productos;

public abstract class Producto {

    //ATRIBUTOS ESTATICOS
    //STATIC vive a nivel de clase, no de instancia. por eso se puede usar para los id
    private static int contadorId = 0;
    private static int totalProductos = 0;

    //ATRIBUTOS
    private int id;
    private String nombre;
    private Double precio;
    private int stock;

    //CONSTRUCTORES
    public Producto(String nombre, Double precio, int stock) {
        this.id = ++contadorId;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        totalProductos++;
    }

    public Producto(String nombre, Double precio) {
        this.id = ++contadorId;
        this.nombre = nombre;
        this.precio = precio;
        totalProductos++;
    }

    public Producto() {
        this.id = ++contadorId;
    }

    // metodos propios de la clase
    public void mostrarDatos() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}