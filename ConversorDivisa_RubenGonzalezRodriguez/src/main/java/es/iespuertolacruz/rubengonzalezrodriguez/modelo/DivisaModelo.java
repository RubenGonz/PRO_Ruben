package es.iespuertolacruz.rubengonzalezrodriguez.modelo;

import java.util.HashMap;

import es.iespuertolacruz.rubengonzalezrodriguez.api.Divisa;
import es.iespuertolacruz.rubengonzalezrodriguez.exception.DivisaException;

/**
 * Clase que guarda la informacion de las divisas y la usa
 */
public class DivisaModelo {

    // Variables de clase

    HashMap<String, Divisa> listaDivisas;

    // Constructores

    /**
     * Constructor por defecto de DivisaModelo
     */
    public DivisaModelo() {
        listaDivisas = new HashMap<>();
    }

    // Metodos y funciones

    /**
     * Metodo que inserta una divisa si no existe
     * 
     * @param divisa a insertar
     * @throws DivisaException excepcion propia
     */
    public void insertar(Divisa divisa) throws DivisaException {
        if (existe(divisa)) {
            throw new DivisaException("La divisa que intenta insertar en la lista ya esta insertada");
        }
        listaDivisas.put(divisa.getCodigo(), divisa);
    }

    /**
     * Metodo que elimina una divisa de la lista si existiese
     * 
     * @param divisa a eliminar
     * @throws DivisaException excepcion propia
     */
    public void eliminar(Divisa divisa) throws DivisaException {
        if (!existe(divisa)) {
            throw new DivisaException("La divisa que intenta eliminar de la lista no esta insertada");
        }
        listaDivisas.remove(divisa.getCodigo(), divisa);
    }

    /**
     * Funcion que pasado un codigo te busca una divisa
     * 
     * @param codDivisa codigo de la divisa a buscar
     * @return la divisa a buscar o null
     */
    public Divisa buscar(String codDivisa) {
        Divisa divisa = null;
        divisa = listaDivisas.get(codDivisa);
        return divisa;
    }

    /**
     * Funcion que averigua si la divisa existe en la lista
     * 
     * @param divisa a comprobar
     * @return true si existe o false si no existe
     */
    public boolean existe(Divisa divisa) {
        Divisa divisaAencontrar;
        divisaAencontrar = buscar(divisa.getCodigo());
        if (divisaAencontrar != null) {
            return true;
        }
        return false;
    }

    /**
     * Funcion que devuelve el valor de una divisa
     * 
     * @param codDivisa a obtener
     * @return la divisa
     * @throws DivisaException excepcion propia
     */
    public Divisa obtener(String codDivisa) throws DivisaException {
        Divisa divisa = null;
        divisa = buscar(codDivisa);
        if (divisa == null) {
            throw new DivisaException("La divisa que se quiere obtener no existe");
        }
        return divisa;
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
        float valorDividaOrigen;
        float valorDividaDestino;
        try {
            valorDividaOrigen = obtener(codDivisaOrigen).getValor();
        } catch (DivisaException exception) {
            throw new DivisaException("No se le pudo dar valor a a la variable");
        }
        try {
            valorDividaDestino = obtener(codDivisaDestino).getValor();
        } catch (DivisaException exception) {
            throw new DivisaException("No se le pudo dar valor a a la variable");
        }
        float euros = importe / valorDividaOrigen;
        return euros * valorDividaDestino;
    }

    /**
     * Metodo toString de DivisaModelo
     */
    public String toString() {
        return listaDivisas.toString();
    }
}
