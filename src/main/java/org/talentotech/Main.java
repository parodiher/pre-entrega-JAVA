package org.talentotech;

import org.talentotech.exceptions.ProductoNotFoundException;
import org.talentotech.productos.Producto;
import org.talentotech.service.ProductoService;
import org.talentotech.util.InputScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de gestion de compra venta");
        ProductoService productoService = new ProductoService();
        int flag =0;
        while (flag == 0){
            System.out.println("Por favor ingrese la opción correspondiente: ");
            System.out.println("""
                    1) Agregar producto
                    2) Listar productos
                    3) Buscar/Actualizar producto
                    4) Eliminar producto
                    5) Crear un pedido
                    6) Listar pedidos
                    7) Salir
                    
                    \s
                    """);

            boolean seleccionCorrecta =false;
            List opciones = new ArrayList<>();
            for (int i =1; i<=7; i++){
                opciones.add(i);
            }
            while (seleccionCorrecta == false){
                int seleccion = InputScanner.leerEntero("Elija una opción: ");
                if (opciones.contains(seleccion)){
                    switch (seleccion){
                        //Agregar producto
                        case 1:
                            int repetirProceso=1;
                            while (repetirProceso ==1) {
                                Scanner nuevoScanner = new Scanner(System.in);

                                System.out.println("Ingrese Tipo de Producto");
                                int tipoProducto = InputScanner.leerEntero("1) Comida    2) Bebida");

                                switch (tipoProducto){
                                    case 1:
                                        productoService.agregarComida();
                                        break;
                                    case 2:
                                        productoService.agregarBebida();
                                        break;
                                }
                                System.out.println("¿Desea agregar otro producto?");
                                System.out.println("------------------------------");
                                repetirProceso = InputScanner.leerEntero("1. Si       2. No");
                            }
                            break;
                        //Mostrar productos
                        case 2:
                            productoService.mostrarProductos();
                            break;
                        //Buscar Productos
                        case 3:
                            int busqueda =InputScanner.leerEntero("""
                                    Como desea buscar el producto?
                                    
                                    1) Nombre       2) ID\s""");
                            if(busqueda==1){
                                String nombre = InputScanner.leerTexto("Ingrese nombre de producto a buscar: ");

                                try {
                                    Producto p = productoService.buscarProducto(nombre);
                                    p.mostrarDatos();
                                } catch (ProductoNotFoundException e) {
                                    System.out.println(e.getMessage());
                                }
                            }else if(busqueda==2){
                                int id = InputScanner.leerEntero("Ingrese ID de producto a buscar: ");

                                try {
                                    Producto p = productoService.buscarProducto(id);
                                    p.mostrarDatos();
                                } catch (ProductoNotFoundException e) {
                                    System.out.println(e.getMessage());
                                }
                            }else{
                                System.out.println("Ingrese una opcion correcta");
                            }

                            int actualizacion = InputScanner.leerEntero("""
                                    Desea actualizar el producto? 
                                    1) Actualizar stock
                                    2) Actualizar precio
                                    3) Salir""");
                            switch (actualizacion){
                                case 1:
                                    productoService.actualizarStock(InputScanner.leerEntero("Ingrese ID del producto a actualizar: "));
                                    break;
                                case 2:
                                    productoService.actualizarPrecio(InputScanner.leerEntero("Ingrese ID del producto a actualizar: "));
                                default:
                                    break;

                            }


                            break;
                        //Eliminar producto
                        case 4:

                            int id = InputScanner.leerEntero("Ingrese id del Producto a eliminar: ");
                            try {
                                productoService.eliminarProducto(id);
                                System.out.println("Producto eliminado");
                            } catch (ProductoNotFoundException e) {
                                System.out.println(e.getMessage());
                            }

                            break;

                        case 5:


                            break;

                        case 6:
                            break;

                        case 7:
                            System.out.println("Gracias, vuelva pronto!");
                            flag=1;
                            break;


                    }
                    seleccionCorrecta =true;
                }else {
                    System.out.println("Se ha ingresado una opcion incorrecta");
                }
            }

        }
    }
}