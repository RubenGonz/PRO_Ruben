package es.iespuertolacruz.rubengonzalezrodriguez.elementos;

import java.util.Objects;

public class Nota {
    
    // Variables de la clase

    String asignatura;
    int calificacion;

    // Constructores

    /**
     * Constructor por defecto
     */
    public Nota() {
    }

    /**
     * Constructor con parametros 
     * 
     * @param asignatura de la que se evalua un alumno
     * @param calificacion nota sacada en la asignatura
     */
    public Nota(String asignatura, int calificacion) {
        this.asignatura = asignatura;
        this.calificacion = calificacion;
    }

    // Getter and Setter

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

    // Metodos y funciones

    @Override
    public String toString() {
        return "{" +
            " asignatura='" + getAsignatura() + "'" +
            ", calificacion='" + getCalificacion() + "'" +
            "}";
    }

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

}
