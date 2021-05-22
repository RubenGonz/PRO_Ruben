package es.iespuertolacruz.rubengonzalezrodriguez.api;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Persona {

    // Variables de clase

    private static final String DELIMITADOR = "'";
    String dni;
    String nombre;
    String fechaNacimiento;
    String direccion;
    int telefono;

    // Constructores

    /**
     * Constructor por defecto
     */
    public Persona() {
    }

    /**
     * Constructor con todos los parametros
     * 
     * @param dni             de la persona
     * @param nombre          de la persona
     * @param fechaNacimiento de la persona
     * @param direccion       de la persona
     * @param telefono        de la persona
     */
    public Persona(String dni, String nombre, String fechaNacimiento, String direccion, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
     * Constructor que recibe una cadena de texto
     * 
     * @param cadena con la informacion
     */
    public Persona(String cadena) {
        ArrayList<Object> elementos = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(cadena, DELIMITADOR);
        while (tokenizer.hasMoreElements()) {
            elementos.add(tokenizer.nextToken());
        }
        this.dni = (String) elementos.get(0);
        this.nombre = (String) elementos.get(1);
        this.fechaNacimiento = (String) elementos.get(2);
        this.direccion = (String) elementos.get(3);
        this.telefono = Integer.parseInt((String) elementos.get(4));
    }

    // Getters and Setters

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

    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    // Funciones y metodos

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Persona)) {
            return false;
        }
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni) && Objects.equals(nombre, persona.nombre)
                && Objects.equals(fechaNacimiento, persona.fechaNacimiento)
                && Objects.equals(direccion, persona.direccion) && telefono == persona.telefono;
    }

    @Override
    public String toString() {
        return getDni() + DELIMITADOR + 
        getNombre() + DELIMITADOR + 
        getFechaNacimiento() + DELIMITADOR + 
        getDireccion() + DELIMITADOR + 
        getTelefono();
    }

}
