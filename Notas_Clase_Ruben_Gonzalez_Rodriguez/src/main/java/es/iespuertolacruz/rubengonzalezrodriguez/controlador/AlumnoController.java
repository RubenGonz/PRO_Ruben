package es.iespuertolacruz.rubengonzalezrodriguez.controlador;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Alumno;
import es.iespuertolacruz.rubengonzalezrodriguez.excepcion.AlumnoException;
import es.iespuertolacruz.rubengonzalezrodriguez.modelo.AlumnosModelo;

public class AlumnoController {

    // Variables de clase

    private static final String EL_ALUMNO_INDICADO_NO_EXISTE = "El alumno indicado no existe";
    AlumnosModelo alumnosModelo;

    /**
     * Constructor por defecto con alumnoModelo inicializado
     */
    public AlumnoController() {
        alumnosModelo = new AlumnosModelo();
    }

    /**
     * Metodo que valida si un alumno es valido o no
     * 
     * @param alumno a validar
     * @throws AlumnoException excepcion propia
     */
    public void validarAlumno(Alumno alumno) throws AlumnoException {
        String mensaje = "";

        if (alumno == null) {
            mensaje = "Se esta validando un objeto nulo de alumno";
            throw new AlumnoException(mensaje);
        }

        if (alumno.getDni() == null || alumno.getDni().isEmpty()) {
            mensaje += "El dni del alumno es nulo o vacio, ";
        }

        if (alumno.getNombre() == null || alumno.getNombre().isEmpty()) {
            mensaje += "el nombre del alumno es nulo o vacio, ";
        }

        if (alumno.getApellido1() == null || alumno.getApellido1().isEmpty()) {
            mensaje += "el primer apellido del alumno es nulo o vacio, ";
        }

        if (alumno.getApellido2() == null || alumno.getApellido2().isEmpty()) {
            mensaje += "el segundo apellido del alumno es nulo o vacio.";
        }

        if (!mensaje.isEmpty()) {
            throw new AlumnoException(mensaje);
        }
    }

    /**
     * Metodo encargado de insertar un alumno en la lista de alumnos
     * 
     * @param alumno a insertar
     * @throws AlumnoException con mensaje controlado
     */
    public void insertar(Alumno alumno) throws AlumnoException {
        validarAlumno(alumno);
        if (existe(alumno)) {
            throw new AlumnoException("El alumno indicado ya existe");
        }
        alumnosModelo.insertar(alumno);
    }

    /**
     * Metodo encargado de eliminar un alumno en la lista de alumnos por el alumno
     * 
     * @param fruta a eliminar
     * @throws AlumnoException con mensaje controlado
     */
    public void eliminar(Alumno alumno) throws AlumnoException {
        validarAlumno(alumno);
        if (!existe(alumno)) {
            throw new AlumnoException(EL_ALUMNO_INDICADO_NO_EXISTE);
        }
        alumnosModelo.eliminar(alumno);
    }

    /**
     * Metodo encargado de eliminar un alumno en la lista de alumnos por el dni
     * 
     * @param dni del alumno
     * @throws AlumnoException con mensaje controlado
     */
    public void eliminar(String dni) throws AlumnoException {
        Alumno alumno;
        alumno = buscar(dni);
        if (alumno == null) {
            throw new AlumnoException(EL_ALUMNO_INDICADO_NO_EXISTE);
        }
        alumnosModelo.eliminar(alumno);
    }

    /**
     * Funcion encargada de buscar un alumno en la lista de alumnos por el dni
     * 
     * @param dni del alumno
     * @return alumno encontrado o null si no esta
     */
    public Alumno buscar(String dni) {
        Alumno alumno = null;
        alumno = alumnosModelo.buscar(dni);
        return alumno;
    }

    /**
     * Funcion encargada de verificar si existe el alumno
     * 
     * @param alumno a comprobar
     * @return true si existe o false si no existe
     */
    public boolean existe(Alumno alumno) {
        boolean encontrado = false;
        Alumno alumnoEncontrado;

        alumnoEncontrado = buscar(alumno.getDni());
        if (alumnoEncontrado != null) {
            encontrado = true;
        }
        return encontrado;
    }

}
