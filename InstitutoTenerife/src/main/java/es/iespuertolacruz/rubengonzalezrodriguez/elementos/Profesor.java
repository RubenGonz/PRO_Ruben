package es.iespuertolacruz.rubengonzalezrodriguez.elementos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Profesor extends Persona{
    
    // Variables de clase

    ArrayList<Aula> aulas = new ArrayList<>();

    // Constructores

    /**
     * Constructor por defecto
     */
    public Profesor() {
    }

    /**
     * Constructor con parametros
     * 
     * @param dni del profesor
     * @param nombre del profesor
     * @param apellidos del profesor
     * @param aulas lista de aulas en las que imparte clase
     */
    public Profesor(String dni, String nombre, String apellidos, List<Aula> aulas) {
        super(dni, nombre, apellidos);
        this.aulas = (ArrayList<Aula>) aulas;
    }

    // Getter and Setter

    public List<Aula> getAulas() {
        return this.aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = (ArrayList<Aula>) aulas;
    }

    // Metodos y funciones

    /**
     * Metodo en el que se inserta un aula
     * 
     * @param aula a insertar
     */
    public void insertar(Aula aula) {
        aulas.add(aula);
    }

    /**
     * Metodo que comprueba si existe un aula en la lista aulas
     * 
     * @param aula a comprobar
     * @return True si existe o false si no existe
     */
    public boolean existe(Aula aula) {
        return aulas.contains(aula);
    }

    /**
     * Metodo que elimina una aula de la lista aulas si existe
     * 
     * @param aula a eliminar
     */
    public void eliminar(Aula aula) {
        if (aulas.contains(aula)) {
            aulas.remove(aula);
        }
    }

    @Override
    public String toString() {
        return "{" +
            " aulas='" + getAulas() + "'" +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Profesor)) {
            return false;
        }
        Profesor profesor = (Profesor) o;
        return Objects.equals(aulas, profesor.aulas);
    }

}
