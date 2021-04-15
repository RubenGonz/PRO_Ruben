package es.iespuertolacruz.rubengonzalezrodriguez;

import java.util.Objects;

public class Cuenta {

    // Declaracion de variables de clase

    private String nombre;
    private String numero;
    private float saldo;
    private float tipoInteres;

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
    public Cuenta(String nombre, String numero, float saldo, float tipoInteres) {
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

    public float getSaldo() {
        return this.saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getTipoInteres() {
        return this.tipoInteres;
    }

    public void setTipoInteres(float tipoInteres) {
        this.tipoInteres = tipoInteres;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cuenta)) {
            return false;
        }
        Cuenta cuenta = (Cuenta) o;
        return Objects.equals(nombre, cuenta.nombre) && Objects.equals(numero, cuenta.numero) && saldo == cuenta.saldo && tipoInteres == cuenta.tipoInteres;
    }

    @Override
    public String toString() {
        return "Nombre = " + getNombre() + 
            ", numero = " + getNumero() +
            ", saldo = " + getSaldo() +
            ", tipoInteres = " + getTipoInteres();
    }

}
