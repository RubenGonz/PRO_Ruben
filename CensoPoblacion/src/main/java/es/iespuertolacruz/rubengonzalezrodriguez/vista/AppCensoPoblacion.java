package es.iespuertolacruz.rubengonzalezrodriguez.vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Persona;
import es.iespuertolacruz.rubengonzalezrodriguez.controller.PersonaController;
import es.iespuertolacruz.rubengonzalezrodriguez.excepciones.CensoException;
import es.iespuertolacruz.rubengonzalezrodriguez.excepciones.PersistenciaException;

public class AppCensoPoblacion {

    static PersonaController personaController;

    public AppCensoPoblacion() {
        try {
            personaController = new PersonaController();
        } catch (PersistenciaException e) {
            System.out.println("Se ha producido un error al inicializar personaController");
        }
    }

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        while (!salir) {

            System.out.println("Bienvenido al Menu");
            System.out.println("¿Que va a hacer?");
            System.out.println("0. Salir");
            System.out.println("1. Buscar");
            System.out.println("2. Insertar");
            System.out.println("3. Eliminar");
            System.out.println("4. Modificar");

            try {
                System.out.println("Escribe una de las 4 opciones que hay:");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 0:
                        salir = true;
                        break;
                    case 1:
                        System.out.println("Introduzca el dni de la persona a buscar");
                        String dni = sn.next();
                        personaController.buscar(dni);
                        break;
                    case 2:
                        Persona personaAInsertar = crearPersona();
                        personaController.insertar(personaAInsertar);
                        break;
                    case 3:
                        Persona personaAEliminar = crearPersona();
                        personaController.eliminar(personaAEliminar);
                        break;
                    case 4:
                        Persona personaAModificar = crearPersona();
                        personaController.modificar(personaAModificar);
                        break;
                    default:
                        System.out.println("Solo números entre 0 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            } catch (CensoException e) {
                System.out.println("Hubo un error con los datos insertados: \n" + e);
                sn.next();
            } catch (PersistenciaException e) {
                System.out.println("Hubo un error con la base de datos: \n" + e);
                sn.next();
            }
        }
    }

    public static Persona crearPersona() {
        Scanner sn = new Scanner(System.in);
        Persona persona;
        System.out.println("Inserte el dni de la persona");
        String dni = sn.next();
        System.out.println("Inserte el nombre de la persona");
        String nombre = sn.next();
        System.out.println("Inserte la fecha de nacimiento de la persona");
        String fechaNacimiento = sn.next();
        System.out.println("Inserte la direccion de la persona");
        String direccion = sn.next();
        System.out.println("Inserte el telefono de la persona");
        int telefono = sn.nextInt();
        persona = new Persona(dni, nombre, fechaNacimiento, direccion, telefono);
        return persona;
    }

}