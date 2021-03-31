package es.iespuertolacruz.rubengonzalezrodriguez.elementos;

import java.util.Objects;

import es.iespuertolacruz.rubengonzalezrodriguez.validaciones.ValidacionDni;

public class Persona extends ValidacionDni{
    
    // Variables de la clase

    String dni;
    String nombre;
    String apellidos;

    // Constructores

    /**
     * Constructor por defecto
     */
    public Persona() {
    }

    /**
     * Constructor con parametros
     * 
     * @param dni de la persona
     * @param nombre de la persona
     * @param apellidos de la persona
     */
    public Persona(String dni, String nombre, String apellidos) {
        this.dni = validar(dni);
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    // Getter and Setter

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = validar(dni);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    // Metodos y funciones

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Persona)) {
            return false;
        }
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni) && Objects.equals(nombre, persona.nombre) && Objects.equals(apellidos, persona.apellidos);
    }

    @Override
    public String toString() {
        return "{" +
            " dni='" + getDni() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellidos='" + getApellidos() + "'" +
            "}";
    }

}
