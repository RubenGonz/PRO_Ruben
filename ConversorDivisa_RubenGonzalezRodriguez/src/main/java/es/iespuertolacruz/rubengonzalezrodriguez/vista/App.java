package es.iespuertolacruz.rubengonzalezrodriguez.vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Divisa;
import es.iespuertolacruz.rubengonzalezrodriguez.controller.DivisaController;
import es.iespuertolacruz.rubengonzalezrodriguez.exception.DivisaException;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        DivisaController divisaController;
        divisaController = new DivisaController();

        System.out.println("Bienvenido al convertidor de divisas");
        System.out.println("¿Que desea?");

        while (!salir) {
            System.out.println("0 - Salir");
            System.out.println("1 - Validar una divisa");
            System.out.println("2 - Insertar una divisa");
            System.out.println("3 - Saber si existe la divisa");
            System.out.println("4 - Eliminar una divisa");
            System.out.println("5 - Convertir una divisa");
            System.out.println("6 - Obtener una divisa");
            System.out.println("7 - Mostrar las divisas");

            try {
                System.out.println("Escriba una de las opciones");
                opcion = scanner.nextInt();
                switch (opcion) {
                case 1:
                    System.out.println("Inserte los datos de la divisa que quiere validar");

                    divisaController.validarDivisa(nuevaDivisa());
                    System.out.println("La divisa ha sido validada");
                    break;
                case 2:
                    System.out.println("Quiere insertar una divisa");

                    divisaController.insertar(nuevaDivisa());
                    break;
                case 3:
                    System.out.println("Quiere saber si existe una divisa");

                    boolean existe;
                    existe = divisaController.existe(nuevaDivisa());
                    System.out.println("La respuesta sobre si esta divisa existe es:" + existe);
                    break;
                case 4:
                    System.out.println("Quiere eliminar una divisa");

                    divisaController.eliminar(nuevaDivisa());
                    break;
                case 5:
                    System.out.println("Quiere convertir una divisa");

                    System.out.println("Inserte el codigo de la divisa de origen");
                    String codOrigen = scanner.next();
                    System.out.println("Inserte el codigo de la divisa de destino");
                    String codDestino = scanner.next();
                    System.out.println("Inserte el importe a convertir");
                    float importe = scanner.nextFloat();

                    Float resultado = divisaController.convertir(codOrigen, codDestino, importe);

                    System.out.println("El importe resultante es: " + resultado);
                    break;
                case 6:
                    System.out.println("Quiere obtener una divisa");

                    System.out.println("Inserte el codigo de la divisa");
                    String codDivisa = scanner.next();

                    System.out.println(divisaController.obtener(codDivisa).toString());
                    break;
                case 7:
                    System.out.println("Quiere mostrar las divisas");
                    System.out.println(divisaController.toString());
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo se pueden poner numeros entre el 0 y el 7");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Debes insertar un numero");
                scanner.next();
            } catch (DivisaException e) {
                e.printStackTrace();
            }
        }
    }

    private static Divisa nuevaDivisa() {
        Scanner scanner = new Scanner(System.in);
        Divisa divisa;
        divisa = new Divisa();
        System.out.println("Inserte el codigo de la divisa");
        divisa.setCodigo(scanner.next());
        System.out.println("Inserte el valor de la divisa comparado al euro");
        divisa.setValor(scanner.nextFloat());
        return divisa;
    }
}
