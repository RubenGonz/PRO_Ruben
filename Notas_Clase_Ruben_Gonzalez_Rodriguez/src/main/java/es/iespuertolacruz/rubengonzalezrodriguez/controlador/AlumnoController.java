package es.iespuertolacruz.rubengonzalezrodriguez.controlador;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Alumno;
import es.iespuertolacruz.rubengonzalezrodriguez.excepcion.AlumnoException;
import es.iespuertolacruz.rubengonzalezrodriguez.modelo.AlumnoModelo;

public class AlumnoController {

    // Variables de clase

    AlumnoModelo alumnoModelo;

    /**
     * Constructor por defecto con alumnoModelo inicializado
     */
    public AlumnoController() {
        alumnoModelo = new AlumnoModelo();
    }

    /**
     * Metodo que valida si un alumno es valido o no
     * @param alumno a validar
     * @return true si es valido o una excepcion con mensaje si no lo es
     * @throws AlumnoException excepcion propia
     */
    public boolean validarAlumno(Alumno alumno) throws AlumnoException {
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

        return false;
    }

}
