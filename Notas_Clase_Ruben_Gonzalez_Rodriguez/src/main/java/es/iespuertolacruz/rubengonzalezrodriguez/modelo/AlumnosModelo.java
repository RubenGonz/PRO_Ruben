package es.iespuertolacruz.rubengonzalezrodriguez.modelo;

import java.util.HashMap;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Alumno;

public class AlumnosModelo {

    // Variables de clase

    Alumno alumno;
    HashMap<String, Alumno> alumnos;

    // Constructores

    /**
     * Constructor por defecto de AlumnosModelo
     */
    public AlumnosModelo() {
        alumnos = new HashMap<>();
    }

    // Metodos y funciones

    /**
     * Metodo que inserta un alumno en la lista de alumnos
     * 
     * @param alumno a insertar
     */
    public void insertar(Alumno alumno) {
        alumnos.put(alumno.getDni(), alumno);
    }

    /**
     * Metodo que elimina a un alumno de la lista
     * 
     * @param alumno a eliminar
     */
    public void eliminar(Alumno alumno) {
        alumnos.remove(alumno.getDni());
    }

    /**
     * Funcion que devuelve un alumno buscado por su dni
     * 
     * @param dni a buscar del alumno
     */
    public Alumno buscar(String dni) {
        alumno = alumnos.get(dni);
        return alumno;
    }

    /**
     * Funcion que comprueba si existe un alumno
     * 
     * @param alumno a verificar
     * @return true si existe o false si no existe
     */
    public boolean existe(Alumno alumno) {
        Alumno alumnoAencontrar;
        alumnoAencontrar = buscar(alumno.getDni());
        return alumnoAencontrar != null;
    }

    /**
     * Funcion que muestra el contenido de la lista
     * 
     * @return String con los elementos
     */
    public String mostrarLista() {
        return alumnos.toString();
    }

}
