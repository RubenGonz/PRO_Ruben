package es.iespuertolacruz.rubengonzalezrodriguez.excepciones;

public class FicheroException extends Exception{

    /**
     * Constructor con mensaje
     */
    public FicheroException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con mensaje y causa
     */
    public FicheroException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }
}
