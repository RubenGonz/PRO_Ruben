package es.iespuertolacruz.rubengonzalezrodriguez.excepcion;

public class NotaException extends Exception{

    /**
     * Constructor por defecto con mensaje
     * @param mensaje del error
     */
    public NotaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con mensaje y causa
     * @param mensaje del error
     * @param causa del error
     */
    public NotaException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }
}
