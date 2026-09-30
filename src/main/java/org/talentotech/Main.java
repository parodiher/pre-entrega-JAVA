package org.talentotech;

import org.talentotech.exceptions.ProductoNotFoundException;
import org.talentotech.productos.Comida;
import org.talentotech.productos.Producto;
import org.talentotech.util.GestorProductos;
import org.talentotech.util.InputScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de gestion de compra venta");
        GestorProductos gestorProductos = new GestorProductos();
        int flag =0;
        while (flag == 0){
            System.out.println("Por favor ingrese la opción correspondiente: ");
            System.out.println("""
                    1) Agregar producto
                    2) Listar productos
                    3) Buscar/Actualizar producto por nombre
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
                        case 1:
                            int repetirProceso=1;
                            while (repetirProceso ==1) {
                                Scanner nuevoScanner = new Scanner(System.in);

                                System.out.println("Ingrese Tipo de Producto");
                                int tipoProducto = InputScanner.leerEntero("1) Comida    2) Bebida");

                                switch (tipoProducto){
                                    case 1:
                                        gestorProductos.agregarComida();
                                        break;
                                    case 2:
                                        gestorProductos.agregarBebida();
                                        break;
                                }
                                System.out.println("¿Desea agregar otro producto?");
                                System.out.println("------------------------------");
                                repetirProceso = InputScanner.leerEntero("1. Si       2. No");
                            }
                            break;
                        case 2:
                            gestorProductos.mostrarProductos();
                            break;
                        case 3:
                            String nombre = InputScanner.leerTexto("Ingrese nombre de producto a buscar: ");
                            Producto p = null;
                            try {
                                p = gestorProductos.buscarProducto(nombre);
                                p.mostrarDatos();
                            } catch (ProductoNotFoundException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 4:
                            int id = InputScanner.leerEntero("Ingrese id del Producto a eliminar: ");
                            try {
                                gestorProductos.eliminarProducto(id);
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