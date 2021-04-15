package es.iespuertolacruz.rubengonzalezrodriguez.controlador;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Fruta;
import es.iespuertolacruz.rubengonzalezrodriguez.excepcion.FrutaException;
import es.iespuertolacruz.rubengonzalezrodriguez.modelo.FrutaModelo;

/**
 * Controlador de la clase fruta
 */
public class FrutaController {

    FrutaModelo frutaModelo;

    public FrutaController() {
        frutaModelo = new FrutaModelo();
    }

    /**
     * Metodo que valida el objeto Fruta
     * @param fruta a validar
     * @throws FrutaException
     */
    public void validarFruta(Fruta fruta) throws FrutaException {
        String mensaje =  "";

        if (fruta == null) {
            mensaje = "Se esta intentando validar un objeto vacio";
            throw new FrutaException(mensaje);
        }

        if (fruta.getIdentificador() == null || fruta.getIdentificador().isEmpty()) {
            mensaje +="El identificador de la fruta es nulo o vacío \n";
        }

        if (fruta.getNombre() == null || fruta.getNombre().isEmpty()) {
            mensaje +="El nombre de la fruta es nulo o vacío";
        }

        if (fruta.getCoste() < 0){
            mensaje +="El coste de la fruta es 0 o menor";
        }

        if (fruta.getPrecio() < 0){
            mensaje +="El precio de la fruta es 0 o menor";
        }

        if (!mensaje.isEmpty()) {
            throw new FrutaException(mensaje);
        }
    }

    public void insertar(String identificador, String nombre, String color, float coste, float precio) {
        //lo que sea
    }
}
