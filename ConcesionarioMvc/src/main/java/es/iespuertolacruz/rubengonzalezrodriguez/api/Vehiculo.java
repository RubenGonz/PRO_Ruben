package es.iespuertolacruz.rubengonzalezrodriguez.api;

import java.util.Objects;

/**
 * Clase principal de vehiculo
 */
public class Vehiculo {
    
    //Variables de clase
    String matricula;
    String marca;

    //Constructores

    /**
     * Constructor por defecto de vehiculo
     */
    public Vehiculo() {
    }

    /**
     * Constructor con todos los parametros de vehiculo
     * @param matricula del vehiculo
     * @param marca del vehiculo
     */
    public Vehiculo(String matricula, String marca) {
        this.matricula = matricula;
        this.marca = marca;
    }

    //Getters ans Setters

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    //Funciones y metodos

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vehiculo)) {
            return false;
        }
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(matricula, vehiculo.matricula) && Objects.equals(marca, vehiculo.marca);
    }

    @Override
    public String toString() {
        return "Matricula = " + getMatricula() +
            ", marca = " + getMarca();
    }

}
