package es.iespuertolacruz.rubengonzalezrodriguez.elementos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aula {

    // Variables de clase

    int piso;
    int numero;
    ArrayList<Alumno> alumnos = new ArrayList<>();

    // Constructores

    /**
     * Constructor por defecto
     */
    public Aula() {
    }

    /**
     * Constructor con parametros
     * 
     * @param piso del aula
     * @param numero del aula
     * @param alumnos lista de los alumnos
     */
    public Aula(int piso, int numero, List<Alumno> alumnos) {
        this.piso = piso;
        this.numero = numero;
        this.alumnos = (ArrayList<Alumno>) alumnos;
    }

    // Getter and Setter

    public int getPiso() {
        return this.piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Alumno> getAlumnos() {
        return this.alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = (ArrayList<Alumno>) alumnos;
    }

    // Metodos y funciones

    /**
     * Metodo que inserta un alumno en la lista alumnos
     * 
     * @param alumno a insertar
     */
    public void insertar(Alumno alumno) {
        alumnos.add(alumno);
    }

    /**
     * Metodo que comprueba si existe un alumno en la lista alumnos
     * 
     * @param alumno a comprobar
     * @return True si existe o false si no existe
     */
    public boolean existe(Alumno alumno) {
        return alumnos.contains(alumno);
    }

    /**
     * Metodo que elimina a un alumno de la lista alumnos si existe
     * 
     * @param alumno a eliminar
     */
    public void eliminar(Alumno alumno) {
        if (alumnos.contains(alumno)) {
            alumnos.remove(alumno);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Aula)) {
            return false;
        }
        Aula aula = (Aula) o;
        return piso == aula.piso && numero == aula.numero && Objects.equals(alumnos, aula.alumnos);
    }

    @Override
    public String toString() {
        return "{" +
            " piso='" + getPiso() + "'" +
            ", numero='" + getNumero() + "'" +
            ", alumnos='" + getAlumnos() + "'" +
            "}";
    }

}