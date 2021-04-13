package es.iespuertolacruz.rubengonzalezrodriguez;

public class Cuenta {

    // Declaracion de variables de clase

    private String nombre;
    private String numero;
    private double saldo;
    private double tipoInteres;

    //Constructores
    
    /**
     * Constructor por defecto
     */
    public Cuenta() {
        nombre = "";
        numero = "";
        saldo = 0;
        tipoInteres = 0;
    }

    /**
     * Constructor con parámetros
     * @param nombre del propietario de la cuenta
     * @param numero de la cuenta
     * @param saldo de la cuenta
     * @param tipoInteres de la cuenta
     */
    public Cuenta(String nombre, String numero, double saldo, double tipoInteres) {
        this.nombre = nombre;
        this.numero = numero;
        this.saldo = saldo;
        this.tipoInteres = tipoInteres;
    }

    //Getters and Setters

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTipoInteres() {
        return this.tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }
}
