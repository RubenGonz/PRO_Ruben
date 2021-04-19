package es.iespuertolacruz.rubengonzalezrodriguez.api;

import java.util.Objects;

/**
 * Clase nota que tendra los atributos de las notas
 */
public class Nota {
    
    //Variables de la clase

    String asignatura;
    int calificacion;

    //Constructores

    /**
     * Constructor por defecto
     */
    public Nota() {
    }

    /**
     * Constructor con todos los parametros
     * 
     * @param asignatura nombre de la asigntura de la que es la nota
     * @param calificacion nota obtenida
     */
    public Nota(String asignatura, int calificacion) {
        this.asignatura = asignatura;
        this.calificacion = calificacion;
    }

    //Getters y Setters

    public String getAsignatura() {
        return this.asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getCalificacion() {
        return this.calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    //Funciones y metodos

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Nota)) {
            return false;
        }
        Nota nota = (Nota) o;
        return Objects.equals(asignatura, nota.asignatura) && calificacion == nota.calificacion;
    }

    @Override
    public String toString() {
        return "Asignatura = " + getAsignatura() +
            ", calificacion = " + getCalificacion();
    }

}
