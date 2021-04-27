package es.iespuertolacruz.rubengonzalezrodriguez.controller;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Divisa;
import es.iespuertolacruz.rubengonzalezrodriguez.exception.DivisaException;
import es.iespuertolacruz.rubengonzalezrodriguez.modelo.DivisaModelo;

/**
 * Clase que trabaja con la divisa
 */
public class DivisaController {

    // Variables de clase

    DivisaModelo divisaModelo;

    // Constructores

    /**
     * Constructor por defecto
     */
    public DivisaController() {
        divisaModelo = new DivisaModelo();
    }

    // Metodos y funciones

    /**
     * Metodo que valida si una divisa dada es valida
     * 
     * @param divisa a comprobar
     * @throws DivisaException es nuestra excepcion propia
     */
    public void validarDivisa(Divisa divisa) throws DivisaException {
        String mensaje = "";

        if (divisa == null) {
            mensaje = "Se esta intentando validar una divisa que es nula o vacia";
            throw new DivisaException(mensaje);
        }

        if (divisa.getCodigo() == null || divisa.getCodigo().isEmpty()) {
            mensaje += "Se esta intentando validar una divisa con codigo nulo o vacio";
        }

        if (divisa.getValor() < 0) {
            mensaje += "Se esta intentando validar una divisa con valor 0 o menor";
        }

        if (!mensaje.isEmpty()) {
            throw new DivisaException(mensaje);
        }
    }

    /**
     * Metodo que inserta una divisa comprobando si es valida
     * 
     * @param divisa a insertar
     * @throws DivisaException excepcion propia
     */
    public void insertar(Divisa divisa) throws DivisaException {
        validarDivisa(divisa);
        if (existe(divisa)) {
            throw new DivisaException("La divisa indicada ya existe");
        }
        divisaModelo.insertar(divisa);
    }

    /**
     * Metodo que elimina una divisa
     * 
     * @param divisa a eliminar
     * @throws DivisaException excepcion propia
     */
    public void eliminar(Divisa divisa) throws DivisaException {
        if (!existe(divisa)) {
            throw new DivisaException("La divisa indicada no existe");
        }
        divisaModelo.eliminar(divisa);
    }

    /**
     * Funcion encargada de buscar una divisa por su codigo
     * 
     * @param codDivisa a buscar
     * @return la divisa encontrada o null
     */
    public Divisa buscar(String codDivisa) {
        Divisa divisa = null;
        divisa = divisaModelo.buscar(codDivisa);
        return divisa;
    }

    /**
     * Funcion encargada de comprobar si una divisa existe ya
     * 
     * @param divisa a comprobar
     * @return true si existe o false si no existe
     */
    public boolean existe(Divisa divisa) {
        boolean encontrada = false;
        Divisa divisaEncontrada;

        divisaEncontrada = buscar(divisa.getCodigo());
        if (divisaEncontrada != null) {
            encontrada = true;
        }
        return encontrada;
    }

    /**
     * Funcion que devuelve el valor de una divisa
     * 
     * @param codDivisa a obtener
     * @return la divisa
     * @throws DivisaException excepcion propia
     */
    public Divisa obtener(String codDivisa) throws DivisaException {
        try {
            return divisaModelo.obtener(codDivisa);
        } catch (DivisaException e) {
            throw new DivisaException("No se ha podido obtener la divisa");
        }
    }

    /**
     * Funcion que te convierte el valor de una divisa a otra
     * 
     * @param codDivisaOrigen  codigo de la divisa de origen
     * @param codDivisaDestino codigo de la divisa de destino
     * @param importe          valor que se quiere convertir
     * @return valor al cambio
     * @throws DivisaException excepcion propia
     */
    public float convertir(String codDivisaOrigen, String codDivisaDestino, float importe) throws DivisaException {
        try {
            return divisaModelo.convertir(codDivisaOrigen, codDivisaDestino, importe);
        } catch (DivisaException exception) {
            throw new DivisaException("No se ha podido convertir la divisa");
        }
    }

    /**
     * Metodo toString
     */
    public String toString() {
        return divisaModelo.toString();
    }

}
