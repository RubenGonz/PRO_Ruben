package es.iespuertolacruz.rubengonzalezrodriguez.controller;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Divisa;
import es.iespuertolacruz.rubengonzalezrodriguez.exception.DivisaException;
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

    //Metodos y funciones
    
    /**
     * Metodo que valida si una divisa dada es valida
     * @param divisa a comprobar
     * @throws DivisaException es nuestra excepcion propia
     */
    public void validarDivisa(Divisa divisa) throws DivisaException {
        String mensaje = "";

        if(divisa == null) {
            mensaje = "Se esta intentando validar una divisa que es nula o vacia";
            throw new DivisaException(mensaje);
        }

        if (divisa.getCodigo() == null || divisa.getCodigo().isEmpty()) {
            mensaje += "Se esta intentando validar una divisa con codigo es nulo o vacio";
        }
    
        if (divisa.getValor() < 0) {
            mensaje += "Se esta intentando validar una divisa con valor 0 o menor";
        }

        if (!mensaje.isEmpty()) {
            throw new DivisaException(mensaje);
        }
    }

}
