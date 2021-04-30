package es.iespuertolacruz.rubengonzalezrodriguez.excepciones;

public class VehiculoException extends Exception{

    /**
     * Constructor con mensaje
     */
    public VehiculoException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con mensaje y causa
     */
    public VehiculoException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }
    
}
