package es.iespuertolacruz.rubengonzalezrodriguez.elementos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Alumno extends Persona{
    
    // Variables de clase

    ArrayList<Nota> notas = new ArrayList<>();

    // Constructores

    /**
     * Constructor por defecto
     */
    public Alumno() {
    }

    /**
     * Constructor con parametros
     * 
     * @param dni del alumno
     * @param nombre del alumno
     * @param apellidos del alumno
     * @param notas lista de las notas del alumno
     */
    public Alumno(String dni, String nombre, String apellidos, List<Nota> notas) {
        super(dni, nombre, apellidos);
        this.notas = (ArrayList<Nota>) notas;
    }

    // Getter and Setter

    public List<Nota> getNotas() {
        return this.notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = (ArrayList<Nota>) notas;
    }

    // Metodos y funciones

    /**
     * Metodo que añade una nota a la lista notas
     * 
     * @param nota a insertar
     */
    public void insertar(Nota nota) {
        notas.add(nota);
    }

    /**
     * Metodo que comprueba si existe una nota en la lista notas
     * 
     * @param nota a comprobar
     * @return True si existe o false si no existe
     */
    public boolean existe(Nota nota) {
        return notas.contains(nota);
    }

    /**
     * Metodo que elimina una nota si estuviese en la lista
     * 
     * @param nota a eliminar
     */
    public void eliminar(Nota nota) {
        if (notas.contains(nota)) {
            notas.remove(nota);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Alumno)) {
            return false;
        }
        Alumno alumno = (Alumno) o;
        return Objects.equals(notas, alumno.notas);
    }

    @Override
    public String toString() {
        return "{" +
            " notas='" + getNotas() + "'" +
            "}";
    }
    
}
