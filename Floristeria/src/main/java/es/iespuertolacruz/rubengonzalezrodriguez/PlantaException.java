package es.iespuertolacruz.rubengonzalezrodriguez;

public class PlantaException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor por defecto
     * 
     * @param mensaje de error
     */
    public PlantaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructur con mensaje y causa
     * 
     * @param mensaje del error
     * @param causa   del error
     */
    public PlantaException(String mensaje, Exception causa) {
        super(mensaje, causa);
    }
}
