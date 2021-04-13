package es.iespuertolacruz.rubengonzalezrodriguez;

public class GestionCuenta {

    // Variables del sistema

    Cuenta cuenta;

    /**
     * Constructor por defecto
     */
    public GestionCuenta() {
        cuenta = new Cuenta();
    }

    /**
     * Constructor por parámetros
     * 
     * @param cuenta a gestionar
     */
    public GestionCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
        cuenta = new Cuenta();
    }

    // Getters and Setters

    public Cuenta getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    // Metodos y funciones

    /**
     * Metodo que intenta ingresar dinero en una cuenta
     * 
     * @param cantidad a ingresar
     * @throws Exception propia
     */
    public void ingresar(double cantidad) throws CuentaException {
        if (cantidad >= 0) {
            cuenta.setSaldo(cuenta.getSaldo() + cantidad);
        } else {
            throw new CuentaException("No se puede ingresar cantidades negativas");
        }
    }

    /**
     * Metodo que intenta retirar dinero de una cuenta
     * 
     * @param cantidad a extraer
     * @throws Exception propia
     */
    public void retirar(double cantidad) throws CuentaException {
        if (cantidad <= cuenta.getSaldo()) {
            cuenta.setSaldo(cuenta.getSaldo() - cantidad);
        } else if (cantidad > 0) {
            throw new CuentaException("No se puede extraer cantidades negativas");
        } else if (cantidad > cuenta.getSaldo()) {
            throw new CuentaException("Su cuenta no dispone del suficiente saldo");
        }
    }
}
