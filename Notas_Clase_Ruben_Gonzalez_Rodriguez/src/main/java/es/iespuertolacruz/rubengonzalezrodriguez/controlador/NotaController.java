package es.iespuertolacruz.rubengonzalezrodriguez.controlador;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Nota;
import es.iespuertolacruz.rubengonzalezrodriguez.excepcion.NotaException;

public class NotaController {

    // Variables de clase

    
    /**
     * Constructor por defecto con notaModelo inicializada
     */

    public void validarNota(Nota nota) throws NotaException {
        String mensaje = "";

        if (nota == null) {
            mensaje = "Se esta validando un objeto nulo de nota";
            throw new NotaException(mensaje);
        }

        if (nota.getAsignatura() == null || nota.getAsignatura().isEmpty()) {
            mensaje += "La asignatura de la nota es nula o vacia, ";
        }

        if (nota.getCalificacion() <= 0) {
            mensaje += "la calificacion es 0 o menor.";
        }

        if (!mensaje.isEmpty()) {
            throw new NotaException(mensaje);
        }
    }

}
