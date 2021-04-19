package es.iespuertolacruz.rubengonzalezrodriguez.api;

import java.util.Objects;

/**
 * Clase Alumno que contiene las cualidades de alumno
 */
public class Alumno {

    //Variables de clase

    String dni;
    String nombre;
    String apellido1;
    String apellido2;

    //Constructores

    /**
     * Constructor por defecto de alumno
     */
    public Alumno() {
    }

    /**
     * Constructor de alumno con todos los parametros
     * 
     * @param dni del alumno
     * @param nombre del alumno
     * @param apellido1 del alumno
     * @param apellido2 del alumno
     */
    public Alumno(String dni, String nombre, String apellido1, String apellido2) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    //Getters y Setters

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return this.apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return this.apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    //Metodos y funciones

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Alumno)) {
            return false;
        }
        Alumno alumno = (Alumno) o;
        return Objects.equals(dni, alumno.dni) && Objects.equals(nombre, alumno.nombre)
                && Objects.equals(apellido1, alumno.apellido1) && Objects.equals(apellido2, alumno.apellido2);
    }

    @Override
    public String toString() {
        return "Dni = " + getDni() +
            ", nombre = " + getNombre() +
            ", apellido1 = " + getApellido1() +
            ", apellido2 = " + getApellido2();
    }
    
}
