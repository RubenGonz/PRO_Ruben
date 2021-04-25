package es.iespuertolacruz.rubengonzalezrodriguez.vista;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        System.out.println("Bienvenido al convertidor de divisas");
        System.out.println("¿Que desea?");
        
        while (!salir) {
            System.out.println("0 - Salir");
            System.out.println("1 - Insertar Divisa");
            System.out.println("2 - Obtener Divisa");
            System.out.println("3 - Convertir Divisa");
            
            try {
                System.out.println("Escriba una de las opciones");
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo se pueden poner numeros entre el 0 y el 3");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Debes insertar un numero");
                scanner.next();
            }
        }
    }
}
