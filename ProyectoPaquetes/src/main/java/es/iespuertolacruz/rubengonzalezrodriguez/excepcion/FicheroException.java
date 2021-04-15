package es.iespuertolacruz.rubengonzalezrodriguez.excepcion;

public class FicheroException extends Exception{
    
    private static final long serialVersionUID = 1L;

    /**
     * Constructor con el mensaje personalizado
     * @param mensaje del error
     */
    public FicheroException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con la causa y mensaje personalizado
     * @param mensaje del error
     * @param causa del error
     */
    public FicheroException(String mensaje, Exception causa) {
        super(mensaje,causa);
    }
}
