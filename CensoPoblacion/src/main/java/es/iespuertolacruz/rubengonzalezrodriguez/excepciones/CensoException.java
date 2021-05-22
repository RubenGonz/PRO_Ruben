package es.iespuertolacruz.rubengonzalezrodriguez.excepciones;

public class CensoException extends Exception {
    
    private static final long serialVersionUID = 1L;

    /**
     * Constructor con el mensaje personalizado
     * 
     * @param mensaje personalizado
     */
    public CensoException(String mensaje) {
        super(mensaje);
    }
    
}
