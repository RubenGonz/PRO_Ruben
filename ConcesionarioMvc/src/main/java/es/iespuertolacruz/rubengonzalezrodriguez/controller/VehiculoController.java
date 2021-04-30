package es.iespuertolacruz.rubengonzalezrodriguez.controller;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Vehiculo;
import es.iespuertolacruz.rubengonzalezrodriguez.excepciones.VehiculoException;
import es.iespuertolacruz.rubengonzalezrodriguez.modelo.VehiculoModelo;

/**
 * Constrolador de la clase Vehiculo
 */
public class VehiculoController {

    //Variables de clase
    
    VehiculoModelo vehiculoModelo;

    //Constructores

    public VehiculoController() {
        vehiculoModelo = new VehiculoModelo();
    }

    //Metodos y funciones

    public void validar(Vehiculo vehiculo) throws VehiculoException {
        String mensaje;
        if (vehiculo == null) {
            throw new VehiculoException("El vehiculo es nulo");
        }

        
    }

}
