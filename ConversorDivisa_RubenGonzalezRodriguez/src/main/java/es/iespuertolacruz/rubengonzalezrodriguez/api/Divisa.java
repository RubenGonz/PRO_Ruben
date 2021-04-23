package es.iespuertolacruz.rubengonzalezrodriguez.api;

import java.util.Objects;

/**
 * Clase principal de la divisa
 */
public class Divisa {
    
    //Variables de clase

    String codigo;
    Float valor;

    /**
     * Constructor por defecto de la divisa
     */
    public Divisa() {
    }

    /**
     * Constructor con parametros de la divisa
     * @param codigo siglas de la divisa distintivas
     * @param valor de esa divisa comparado con los euros
     */
    public Divisa(String codigo, Float valor) {
        this.codigo = codigo;
        this.valor = valor;
    }

    //Getters and Setters

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Float getValor() {
        return this.valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    //Metodos y funciones

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Divisa)) {
            return false;
        }
        Divisa divisa = (Divisa) o;
        return Objects.equals(codigo, divisa.codigo) && Objects.equals(valor, divisa.valor);
    }

    @Override
    public String toString() {
        return "Codigo = " + getCodigo() +
            ", valor = " + getValor();
    }

}
