package org.talentotech.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputScanner {
    private static final Scanner sc = new Scanner(System.in);

    public static int leerEntero(String mensaje){
        while (true){
            System.out.println(mensaje);
            try {
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;

            }catch (InputMismatchException e){
                System.out.println("Debe ingresar un numero entero. Intente nuevamente: ");
                sc.nextLine();
            }
        }
    }

    public static double leerDouble(String mensaje){
        while (true){
            System.out.println(mensaje);
            try {
                double valor = sc.nextDouble();
                sc.nextLine();
                return valor;

            }catch (InputMismatchException e){
                System.out.println("Debe ingresar un numero double. Intente nuevamente: ");
                sc.nextLine();
            }
        }
    }

    public static String leerTexto(String mensaje){
        System.out.println(mensaje);
        return sc.nextLine();
    }
}
