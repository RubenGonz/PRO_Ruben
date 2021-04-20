package es.iespuertolacruz.rubengonzalezrodriguez.controlador;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Alumno;
import es.iespuertolacruz.rubengonzalezrodriguez.excepcion.AlumnoException;

public class AlumnoController {

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

}
