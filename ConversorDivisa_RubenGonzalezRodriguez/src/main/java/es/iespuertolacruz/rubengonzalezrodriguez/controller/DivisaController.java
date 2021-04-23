package es.iespuertolacruz.rubengonzalezrodriguez.controller;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Divisa;
import es.iespuertolacruz.rubengonzalezrodriguez.modelo.DivisaModelo;

/**
 * Clase que trabaja con la divisa
 */
public class DivisaController {

    //Variables de clase

    DivisaModelo divisaModelo;

    //Constructores

    /**
     * Constructor por defecto
     */
    public DivisaController() {
        divisaModelo = new DivisaModelo();
    }

    public void validarDivisa(Divisa divisa) {
        String mensaje = "";

        if(divisa == null) {
            mensaje = "Se esta intentando validar una divisa que es nula o vacia";
            throw new DivisaException(mensaje);
        }
    }
}
