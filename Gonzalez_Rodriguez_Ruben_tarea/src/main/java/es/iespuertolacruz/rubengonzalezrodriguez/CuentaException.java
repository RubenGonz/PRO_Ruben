package es.iespuertolacruz.rubengonzalezrodriguez;

public class CuentaException extends Exception{

    private static final long serialVersionUID = 1L;

    /**
     * Constructor por defecto con mensaje heredado
     * 
     * @param mensaje del error
     */
    public CuentaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor por parametros mensaje y causa
     * 
     * @param mensaje del error
     * @param causa del error
     */
    public CuentaException(String mensaje, Exception causa) {
        super(mensaje,causa);
    }

}
