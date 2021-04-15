package es.iespuertolacruz.rubengonzalezrodriguez.excepcion;

public class FrutaException extends Exception{

    private static final long serialVersionUID = 1L;
    
    /**
     * Constructor con el mensaje personalizado
     * @param mensaje del error
     */
    public FrutaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con la causa y mensaje personalizado
     * @param mensaje del error
     * @param causa d
     */
    public FrutaException(String mensaje, Exception causa) {
        super(mensaje,causa);
    }

}
