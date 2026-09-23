package org.talentotech;

import org.talentotech.util.GestorProductos;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
                    3) Buscar/Actualizar producto
                    4) Eliminar producto
                    5) Crear un pedido
                    6) Listar pedidos
                    7) Salir
                    
                    Elija una opción:\s
                    """);

            boolean seleccionCorrecta =false;
            List opciones = new ArrayList<>();
            for (int i =1; i<=7; i++){
                opciones.add(i);
            }
            while (seleccionCorrecta == false){
                Scanner scanner = new Scanner(System.in);
                int seleccion;
                try {
                    seleccion = scanner.nextInt();
                    if (opciones.contains(seleccion)){
                        switch (seleccion){
                            case 1:
                                int repetirProceso=1;
                                while (repetirProceso ==1) {
                                    Scanner nuevoScanner = new Scanner(System.in);
                                    String nombre;
                                    String fechaVencimiento;
                                    int stock;
                                    double precio;
                                    String volumen;

                                    System.out.println("Ingrese Tipo de Producto");
                                    System.out.println("1) Comida    2) Bebida");
                                    int tipoProducto = nuevoScanner.nextInt();
                                    Scanner otroScanner = new Scanner (System.in);

                                    switch (tipoProducto){
                                        case 1:
                                            gestorProductos.agregarComida();
                                            break;
                                        case 2:
                                            System.out.println("Ingrese Volumen en Litros");
                                            volumen = otroScanner.nextLine();

                                            System.out.println("Ingrese nombre del producto: ");
                                            nombre = otroScanner.nextLine();

                                            System.out.println("Ingrese precio del producto: ");
                                            precio = otroScanner.nextDouble();

                                            System.out.println("Ingrese cant stock: ");
                                            stock = otroScanner.nextInt();
                                            gestorProductos.agregarBebida(nombre,precio,stock,volumen);

                                            break;
                                    }

                                    System.out.println("¿Desea agregar otro producto?");
                                    System.out.println("------------------------------");
                                    System.out.println("1. Si       2. No");
                                    repetirProceso = nuevoScanner.nextInt();
                                }
                                break;
                            case 2:
                                gestorProductos.mostrarProductos();
                                break;
                            case 3:
                                break;
                            case 4:
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
                } catch (InputMismatchException e) {
                    System.out.println("Se ha ingresado una opcion incorrecta");
                }
            }

        }
    }
}