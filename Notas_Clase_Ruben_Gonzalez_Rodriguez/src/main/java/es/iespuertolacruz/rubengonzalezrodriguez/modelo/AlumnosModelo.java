package es.iespuertolacruz.rubengonzalezrodriguez.modelo;

import java.util.HashMap;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Alumno;
import es.iespuertolacruz.rubengonzalezrodriguez.controlador.AlumnoController;
import es.iespuertolacruz.rubengonzalezrodriguez.excepcion.AlumnoException;

public class AlumnosModelo {

    // Variables de clase

    private static final String EL_ALUMNO_INDICADO_NO_EXISTE = "El alumno indicado no existe";
    Alumno alumno;
    HashMap<String, Alumno> alumnos;
    AlumnoController alumnoController;

    // Constructores

    /**
     * Constructor por defecto de AlumnosModelo
     */
    public AlumnosModelo() {
        alumnos = new HashMap<>();
    }

    // Metodos y funciones

    /**
     * Metodo encargado de insertar un alumno en la lista de alumnos
     * 
     * @param alumno a insertar
     * @throws AlumnoException con mensaje controlado
     */
    public void insertar(Alumno alumno) throws AlumnoException {
        if (existe(alumno)) {
            throw new AlumnoException("El alumno indicado ya existe");
        }
        alumnos.put(alumno.getDni(), alumno);
    }

    /**
     * Metodo encargado de eliminar un alumno en la lista de alumnos por el dni
     * 
     * @param dni del alumno
     * @throws AlumnoException con mensaje controlado
     */
    public void eliminar(String dni) throws AlumnoException {
        alumno = buscar(dni);
        if (alumno == null) {
            throw new AlumnoException(EL_ALUMNO_INDICADO_NO_EXISTE);
        }
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
