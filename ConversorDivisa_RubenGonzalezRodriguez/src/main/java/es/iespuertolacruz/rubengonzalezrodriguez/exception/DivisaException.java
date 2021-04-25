package es.iespuertolacruz.rubengonzalezrodriguez.exception;

/**
 * Excepcion propia de divisa
 */
public class DivisaException extends Exception{
    

    /**
     * Constructor por defecto de nuestra excepcion propia de divisa
     * 
     * @param mensaje descriptivo del error
     */
    public DivisaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con mensaje y causa del error
     * 
     * @param mensaje descriptivo del error
     * @param causa del error
     */
    public DivisaException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }

}
